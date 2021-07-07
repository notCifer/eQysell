package com.projeto.app.configs.tools;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.projeto.app.models.RelatorioOperacao;

public class UserPDFExporter {
    private Document document = new Document(PageSize.A4);
    private List<RelatorioOperacao> operacaoList;

    public UserPDFExporter(List<RelatorioOperacao> listOperacao) {
        this.operacaoList = listOperacao;
    }

    private void writeTableHeader(PdfPTable table) {

    }

    private void writeTableData(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setHorizontalAlignment(10);
        cell.setVerticalAlignment(5);
        cell.setBackgroundColor(new Color(255, 175, 71));
        cell.setPadding(10);

        PdfPCell oPCell = new PdfPCell();
        oPCell.setHorizontalAlignment(5);
        oPCell.setVerticalAlignment(5);
        oPCell.setPadding(10);
        oPCell.setBackgroundColor(new Color(60, 60, 60));
        oPCell.setBorderColorLeft(new Color(60, 60, 60));
        oPCell.setBorderWidthLeft(1f);
        oPCell.setBorderColorRight(new Color(60, 60, 60));
        oPCell.setBorderWidthRight(1f);

        PdfPCell bodyCell = new PdfPCell();
        oPCell.setHorizontalAlignment(20);
        oPCell.setVerticalAlignment(5);
        bodyCell.setPadding(4);
        bodyCell.setBackgroundColor(new Color(255, 175, 71));
        bodyCell.setBorderColorLeft(new Color(60, 60, 60));
        bodyCell.setBorderWidthLeft(1f);
        bodyCell.setBorderColorRight(new Color(60, 60, 60));
        bodyCell.setBorderWidthRight(1f);

        PdfPCell totalCell = new PdfPCell();
        totalCell.setPadding(4);
        totalCell .setBackgroundColor(new Color(255, 255, 255));

        PdfPCell finalCell = new PdfPCell();
        finalCell.setPadding(70);
        finalCell.setBackgroundColor(new Color(255, 255, 255));
        finalCell.setBorderColorTop(new Color(255, 255, 255));
        finalCell.setBorderWidthTop(1f);
        finalCell.setBorderColorLeft(new Color(255, 255, 255));
        finalCell.setBorderWidthLeft(1f);
        finalCell.setBorderColorRight(new Color(255, 255, 255));
        finalCell.setBorderWidthRight(1f);        
        finalCell.setBorderColorBottom(new Color(255, 255, 255));
        finalCell.setBorderWidthBottom(1f);

        Font font = FontFactory.getFont(FontFactory.COURIER);
        font.setSize(13);

        Font font2 = FontFactory.getFont(FontFactory.COURIER_BOLD);
        font2.setSize(15);
        font2.setColor(Color.DARK_GRAY);

        
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(12);
        font1.setStyle(4);
        font1.setColor(Color.DARK_GRAY);

        Font fontTotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTotal.setSize(15);
        fontTotal.setColor(Color.DARK_GRAY);
        
        for (RelatorioOperacao operacao : operacaoList) { 

            
            finalCell.setPhrase(new Phrase(""));
            table.addCell(finalCell);
            finalCell.setPhrase(new Phrase(""));
            table.addCell(finalCell);
            
            String nome = operacao.getOperacao().getNome();
            oPCell.setPhrase(new Phrase(nome,FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, Font.NORMAL, new Color(255, 175, 71))));
            table.addCell(oPCell);
            oPCell.setPhrase(new Phrase(""));
            table.addCell(oPCell);


            cell.setPhrase(new Phrase("Despesas Comuns", font1));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Valor individual", font1));
            table.addCell(cell);


            table.addCell(new Phrase("Segurança / Limpeza ",font));

            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getSeg_limpeza()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Sanepar ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getSanepar()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Copel ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getCopel()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Mat.Limpeza ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getMat_limpeza()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Seguro ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getSeguro()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Marketing ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getMarketing()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Cont. Praga ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getCont_praga()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Honorários ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getHonorario()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Entretenimento ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getEntreterimento()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Locações ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getLocacao()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Telefonia e Internet ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getInternet()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Manutenção ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getManutencao()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Impostos ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getImpostos()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Coleta de Lixo ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getColeta_lixo()),font2));
            table.addCell(bodyCell);

            table.addCell(new Phrase("Mat. Exp: ",font));
            bodyCell.setPhrase(new Phrase("R$" + String.format("%10.2f", operacao.getMat_expediente()),font2));
            table.addCell(bodyCell);

            totalCell.setPhrase(new Phrase("                                TOTAL",fontTotal));
            table.addCell(totalCell);
            totalCell.setPhrase(new Phrase("R$  " + String.format("%10.2f", operacao.getTotal()),fontTotal));
            table.addCell(totalCell);

            finalCell.setPhrase(new Phrase(""));
            table.addCell(finalCell);
            finalCell.setPhrase(new Phrase(""));
            table.addCell(finalCell);
        }
     
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        // Font fontp = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        // fontp.setSize(18);
        // fontp.setColor(Color.DARK_GRAY);
        // Paragraph p = new Paragraph("Relatório : " + operacao.getOperacao().getNome(), fontp);
        // p.setAlignment(Paragraph.ALIGN_CENTER);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90);
        table.setWidths(new float[] { 1.5f, 0.5f });
        writeTableHeader(table);
        writeTableData(table);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(table);
        document.close();
    }
}