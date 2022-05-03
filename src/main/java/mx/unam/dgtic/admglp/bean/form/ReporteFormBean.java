package mx.unam.dgtic.admglp.bean.form;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import mx.unam.dgtic.admglp.bean.model.PedidoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import mx.unam.dgtic.admglp.mensajes.MessageBean;
import mx.unam.dgtic.admglp.vo.Empleado;
import mx.unam.dgtic.admglp.vo.Orden;
import mx.unam.dgtic.admglp.vo.Pedido;

/**
 * Bean con la informacion del articulo a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class ReporteFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer estatus;
    private Integer idcliente;
    private Integer idempleado;
    private Integer iddireccion;
    private Date f_ped_ini;
    private Date f_ped_fin;
    private Double total;
    private List<Integer> listaEstatus;
    private List<Pedido> pedidos = new ArrayList<>();

    @Inject
    private PedidoModel pedidoModel;

    @Inject
    private MessageBean messageBean;

    public String buscaReportePedido() {
        pedidos = pedidoModel.cargaPedidosCriteria(estatus, idcliente, idempleado, iddireccion, f_ped_ini, f_ped_fin, total, listaEstatus);
        return "/pedido/reporte?faces-redirect=true";
    }

    public void reporte() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        String fileName = "Pedido.pdf";
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream out = response.getOutputStream();
        try {
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4, 10f, 10f, 45f, 25f);

            /* Basic PDF Creation inside servlet */
            PdfWriter pdfWriter = PdfWriter.getInstance(document, pdfOutputStream);

            document.open();
            PdfContentByte cb = pdfWriter.getDirectContent();
            tablaPedidos(document);

            document.close();
            int total = pdfWriter.getPageNumber();

            byte[] pdfAsBytes = pdfOutputStream.toByteArray();

            PdfReader reader = new PdfReader(pdfAsBytes);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            DataOutputStream output = new DataOutputStream(outputStream);
            PdfStamper stamper = new PdfStamper(reader, output);

            PdfContentByte pagecontent;
            for (int i = 1; i <= total; i++) {
                pagecontent = stamper.getOverContent(i);
                encabezadoReporte(pagecontent, i, total);
            }
            stamper.close();
            byte[] finalPdfAsBytes = outputStream.toByteArray();
            out.write(finalPdfAsBytes);

        } catch (Exception exc) {
            throw new IOException(exc.getMessage());
        } finally {
            out.close();
        }

        fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
    }

    public void encabezadoReporte(PdfContentByte cb, int pagina, int totalPaginas) {
        Phrase titulo1 = new Phrase("Uiversidad Nacional Autónoma de México", FontFactory.getFont(FontFactory.TIMES, 11, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        Phrase titulo2 = new Phrase("Sistema de Administración ADMGLP", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        Phrase titulo3 = new Phrase("Hoja " + pagina + " de " + totalPaginas, FontFactory.getFont(FontFactory.TIMES, 7, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        Phrase titulo4 = new Phrase("Fecha: " + sdf.format(d), FontFactory.getFont(FontFactory.TIMES, 7, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));

        Phrase linea = new Phrase("_", FontFactory.getFont(FontFactory.TIMES, 8, Font.NORMAL, new BaseColor(0x00, 0x00, 0x00)));

        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo1, 36, 815, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo2, 36, 805, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo3, 282, 805, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, titulo4, 582, 805, 0);
        for (int i = 27; i <= 580; i++) {
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, linea, i, 803, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, linea, i, 801, 0);
        }
    }

    public PdfPCell agregaCelda(String texto, int alineacion, int filas, int columnas, int tamLetra, List<Boolean> bordes) {
        PdfPCell celda = null;
        try {
            Font font = FontFactory.getFont(FontFactory.TIMES, tamLetra, Font.NORMAL, new BaseColor(0x00, 0x00, 0x00));
            Phrase phrase = new Phrase(texto, font);
            celda = new PdfPCell(phrase);
            celda.setHorizontalAlignment(alineacion);
            celda.setRowspan(filas);
            celda.setColspan(columnas);
            int iBordes = 0;
            if (bordes.get(0)) {
                iBordes += Rectangle.TOP;
            }
            if (bordes.get(1)) {
                iBordes += Rectangle.BOTTOM;
            }
            if (bordes.get(2)) {
                iBordes += Rectangle.LEFT;
            }
            if (bordes.get(3)) {
                iBordes += Rectangle.RIGHT;
            }
            celda.setBorder(iBordes);
        } catch (Exception e) {
        }
        return celda;
    }

    public void tablaPedidos(Document document) {
        try {
            List<Pedido> pedidos = pedidoModel.cargaPedidosCriteria(estatus, idcliente, idempleado, iddireccion, f_ped_ini, f_ped_fin, total, listaEstatus);

            for (Pedido pedido : pedidos) {
                PdfPTable table = new PdfPTable(8);
                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

                table.addCell(agregaCelda("Cliente:", Element.ALIGN_CENTER, 1, 1, 8, Arrays.asList(false, false, false, false)));
                if (pedido.getCliente() != null) {
                    String nombreCliente = pedido.getCliente().getUsuario().getNombreCompleto();
                    table.addCell(agregaCelda(nombreCliente, Element.ALIGN_LEFT, 1, 3, 8, Arrays.asList(false, false, false, false)));
                }

                table.addCell(agregaCelda("Empleado:", Element.ALIGN_CENTER, 1, 1, 8, Arrays.asList(false, false, false, false)));
                if (pedido.getEmpleados() != null) {
                    String empleados = "";
                    for (Empleado empleado : pedido.getEmpleados()) {
                        empleados += empleado.getUsuario().getNombreCompleto() + "\n";
                    }
                    table.addCell(agregaCelda(empleados, Element.ALIGN_LEFT, 1, 3, 8, Arrays.asList(false, false, false, false)));
                }

                String direccion = pedido.getDireccion().getNombre();
                String referencias = pedido.getDireccion().getReferencias();
                String asentamiento = pedido.getDireccion().getAsentamiento().getNombre();
                String municipio = pedido.getDireccion().getAsentamiento().getMunicipio().getNombre();
                String estado = pedido.getDireccion().getAsentamiento().getMunicipio().getEstado().getNombre();
                String codigoPostal = pedido.getDireccion().getAsentamiento().getCodigoPostal();

                //******************************************** DIRECCION *********************************************
                table.addCell(agregaCelda("Dirección: ", Element.ALIGN_CENTER, 1, 1, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(direccion, Element.ALIGN_LEFT, 1, 3, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Referencia: ", Element.ALIGN_CENTER, 1, 1, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(referencias, Element.ALIGN_CENTER, 1, 3, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(asentamiento, Element.ALIGN_CENTER, 1, 4, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(estado, Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(municipio, Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("", Element.ALIGN_CENTER, 1, 4, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("C.P.", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(codigoPostal, Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));

                //******************************************** PEDIDO *********************************************
                table.addCell(agregaCelda(" ", Element.ALIGN_CENTER, 1, 8, 7, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Pedido ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Entrega ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Pago ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Estado ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
                String fecPedido = "";
                String fecEntrega = "";
                if (pedido.getFecpedido() != null) {
                    fecPedido += sdf.format(pedido.getFecpedido());
                }
                if (pedido.getFecentrega() != null) {
                    fecEntrega += sdf.format(pedido.getFecentrega());
                }

                table.addCell(agregaCelda(fecPedido, Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda(fecEntrega, Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Pago ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Estado ", Element.ALIGN_CENTER, 1, 2, 8, Arrays.asList(false, false, false, false)));

                //******************************************** ARTICULOS *********************************************
                table.addCell(agregaCelda(" ", Element.ALIGN_CENTER, 1, 8, 7, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("", Element.ALIGN_CENTER, 1, 4, 7, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Articulo ", Element.ALIGN_CENTER, 1, 2, 7, Arrays.asList(false, true, false, false)));
                table.addCell(agregaCelda("Unidad", Element.ALIGN_CENTER, 1, 1, 7, Arrays.asList(false, true, false, false)));
                table.addCell(agregaCelda("Precio ", Element.ALIGN_RIGHT, 1, 1, 7, Arrays.asList(false, true, false, false)));

                DecimalFormat df = new DecimalFormat("0.00");
                for (Orden orden : pedido.getOrdenesP()) {
                    if (orden.getCantidad() > 0) {
                        table.addCell(agregaCelda("", Element.ALIGN_CENTER, 1, 4, 7, Arrays.asList(false, false, false, false)));
                        table.addCell(agregaCelda(orden.getArticulo().getNombre(), Element.ALIGN_CENTER, 1, 2, 7, Arrays.asList(false, false, false, false)));
                        table.addCell(agregaCelda("" + orden.getCantidad(), Element.ALIGN_CENTER, 1, 1, 7, Arrays.asList(false, false, false, false)));
                        table.addCell(agregaCelda("$ " + df.format(orden.getSubtotal()), Element.ALIGN_RIGHT, 1, 1, 7, Arrays.asList(false, false, false, false)));
                    }
                }
                table.addCell(agregaCelda("", Element.ALIGN_CENTER, 1, 6, 7, Arrays.asList(false, false, false, false)));
                table.addCell(agregaCelda("Total", Element.ALIGN_CENTER, 1, 1, 7, Arrays.asList(false, false, false, false)));

                table.addCell(agregaCelda("$ " + df.format(pedido.getTotal()), Element.ALIGN_RIGHT, 1, 1, 7, Arrays.asList(false, false, false, false)));

                table.addCell(agregaCelda(" ", Element.ALIGN_CENTER, 1, 8, 8, Arrays.asList(true, false, false, false)));
                document.add(table);
            }

        } catch (Exception e) {
        }

    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Date getF_ped_ini() {
        return f_ped_ini;
    }

    public void setF_ped_ini(Date f_ped_ini) {
        this.f_ped_ini = f_ped_ini;
    }

    public Date getF_ped_fin() {
        return f_ped_fin;
    }

    public void setF_ped_fin(Date f_ped_fin) {
        this.f_ped_fin = f_ped_fin;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Integer> getListaEstatus() {
        return listaEstatus;
    }

    public void setListaEstatus(List<Integer> listaEstatus) {
        this.listaEstatus = listaEstatus;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
