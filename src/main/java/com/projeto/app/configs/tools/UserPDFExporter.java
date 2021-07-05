package com.projeto.app.configs.tools;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.projeto.app.models.RelatorioOperacao;

public class UserPDFExporter {

    private List<RelatorioOperacao> operacaoList;

    public UserPDFExporter(List<RelatorioOperacao> listOperacao) {
        this.operacaoList = listOperacao;
    }

    private void writeTableHeader(PdfPTable table) {

    }

    private void writeTableData(PdfPTable table) {
        table.setSpacingBefore(10);
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(5);
        cell.setVerticalAlignment(5);
        cell.setBackgroundColor(Color.ORANGE);
        cell.setPadding(10);

        for (RelatorioOperacao operacao : operacaoList) {  

            table.addCell(new Phrase("\t\tOPERAÇÃO"));
            table.addCell(operacao.getOperacao().getNome());

            Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
            font1.setSize(12);
            font1.setStyle(1);
            font1.setColor(Color.DARK_GRAY);
            cell.setPhrase(new Phrase("Despesas Comuns", font1));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Valor individual", font1));
            table.addCell(cell);

            Font font = new Font(12);
            font.setSize(11);
            table.getHorizontalAlignment();
            table.addCell((new Phrase("\nSegurança / Limpeza: ",font)));
            table.addCell("R$" + String.format("%10.2f", operacao.getSeg_limpeza()));
            table.addCell("\nSanepar: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getSanepar()));
            table.addCell("\nCopel: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getCopel()));
            table.addCell("\nMat.Limpeza: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getMat_limpeza()));
            table.addCell("\nSeguro: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getSeguro()));
            table.addCell("\nMarketing: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getMarketing()));
            table.addCell("\nCont. Praga: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getCont_praga()));
            table.addCell("\nHonorários: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getHonorario()));
            table.addCell("\nEntretenimento: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getEntreterimento()));
            table.addCell("\nLocações: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getLocacao()));
            table.addCell("\nTelefonia e Internet: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getInternet()));
            table.addCell("\nManutenção: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getManutencao()));
            table.addCell("\nImpostos: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getImpostos()));
            table.addCell("\nColeta de Lixo: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getColeta_lixo()));
            table.addCell("\nMat. Exp: ");
            table.addCell("R$" + String.format("%10.2f", operacao.getMat_expediente()));
            table.addCell("\n   TOTAL   ");
            table.addCell("R$" + String.format("%10.2f", operacao.getTotal()));
            table.addCell("");
            table.addCell("");
                     table.addCell("");
            table.addCell("");
        }
     
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);

        // Font fontp = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        // fontp.setSize(18);
        // fontp.setColor(Color.DARK_GRAY);
        // Paragraph p = new Paragraph("Relatório : " + operacao.getOperacao().getNome(), fontp);
        // p.setAlignment(Paragraph.ALIGN_CENTER);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.setMargins(40, 40, 40, 40);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 3.5f, 3.5f });
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}