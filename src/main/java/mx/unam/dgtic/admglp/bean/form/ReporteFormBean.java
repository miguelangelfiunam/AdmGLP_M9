package mx.unam.dgtic.admglp.bean.form;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.ColumnText;
import mx.unam.dgtic.admglp.bean.model.PedidoModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.unam.dgtic.admglp.mensajes.MessageBean;

/**
 * Bean con la informacion del articulo a mostrar en la vista
 *
 * @author unam
 */
@Named
@SessionScoped
public class ReporteFormBean implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    private Integer idempleado;
    private List<Integer> lista = new ArrayList<>();

    protected Phrase titulo1;
    protected Phrase titulo2;
    protected Phrase titulo3;
    protected Phrase titulo4;
    protected Phrase titulo5;
    protected Phrase titulo6;
    protected Phrase linea = new Phrase("linea");
    protected Image img;
    protected String nombreDep = "nombreDep";
    protected String titulo = "titulo";
    protected String fechaDe = "12/12/2022";
    protected String fechaA = "12/12/2022";
    protected String idEntSal = "fechaDe";

    @Inject
    private PedidoModel articuloModel;

    @Inject
    private MessageBean messageBean;

    public void buscaReportePedido() {
        lista.add(10);
        idempleado = 1;
    }

    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        String fileName = "Pedido.pdf";
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream out = response.getOutputStream();
        try {
            Document document = new Document(PageSize.A4, 10f, 10f, 10f, 0f);

            /* Basic PDF Creation inside servlet */
            PdfWriter writer = PdfWriter.getInstance(document, out);

            document.open();
            PdfContentByte cb = writer.getDirectContent();
            encabezado(writer, document);
            document.close();

            document.close();
        } catch (Exception exc) {
            throw new IOException(exc.getMessage());
        } finally {
            out.close();
        }

        fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
    }

    public void encabezado(PdfWriter writer, Document document) {
        String sNomEntSal = "";
        titulo1 = new Phrase("Uiversidad Nacional Autonoma de México", FontFactory.getFont(FontFactory.TIMES, 11, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        titulo2 = new Phrase("Sistema de Administración ADMGLP", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        
        titulo3 = new Phrase("Hoja  de   ", FontFactory.getFont(FontFactory.TIMES, 7, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        titulo4 = new Phrase("Fecha: ", FontFactory.getFont(FontFactory.TIMES, 7, Font.BOLD, new BaseColor(0x00, 0x00, 0x00)));
        
        linea = new Phrase("_", FontFactory.getFont(FontFactory.TIMES, 8, Font.NORMAL, new BaseColor(0x00, 0x00, 0x00)));

        PdfContentByte cb = writer.getDirectContent();

        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo1, 36, 815, 0);   
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo2, 36, 805, 0);   
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, titulo3, 282, 805, 0);   
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, titulo4, 582, 805, 0);   
        for (int i = 27; i <= 580; i++) {
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, linea, i, 803, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, linea, i, 801, 0);
        }
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

}
