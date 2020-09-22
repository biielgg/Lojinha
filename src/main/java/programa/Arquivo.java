/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author biiel
 */
public class Arquivo {

    private static final String LINK_PLANILHA = "./Arquivo.xlsx";
    private Erro erro = new Erro();
    private Double saldo;    

    private List<Produto> listaProdutos = new ArrayList<>();
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private List<Double> listaSaldo = new ArrayList<>();
    private List<Venda> listaVendas = new ArrayList<>();
    private List<String> listaLog = new ArrayList<>();   

    public Arquivo() {
        try (FileInputStream arquivo = new FileInputStream(new File(LINK_PLANILHA))) {

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            int planilha = workbook.getNumberOfSheets();

            for (int i = 0; i < planilha; i++) {
                /*
                *  Pega a tabela com o número i
                *  e lê as linhas
                */
                XSSFSheet sheetProdutos = workbook.getSheetAt(i); 
                Iterator<Row> rowIterator = sheetProdutos.iterator(); 

                switch (i) {
                    /*
                    *  Enquanto tiver linhas, faça:
                    *  - Pega a linha toda
                    *  - e lê a celula específica
                    */
                    case 0: //Estoque
                        while (rowIterator.hasNext()) { 
                            Row row = rowIterator.next(); 
                            Iterator<Cell> cellIterator = row.cellIterator(); 

                            Produto produto = new Produto();
                            listaProdutos.add(produto);

                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                
                                switch (cell.getColumnIndex()) {
                                    case 0:
                                        produto.setCodigo((int) cell.getNumericCellValue());
                                        break;
                                    case 1:
                                        produto.setNome(String.valueOf(cell.getStringCellValue()));
                                        break;
                                    case 2:
                                        produto.setValor(cell.getNumericCellValue());
                                        break;
                                    case 3:
                                        produto.setQuantidade((int) cell.getNumericCellValue());
                                        break;
                                } 
                            }
                        }
                        break;

                    case 1: //Pessoas
                        while (rowIterator.hasNext()) { 
                            Row row = rowIterator.next(); 
                            Iterator<Cell> cellIterator = row.cellIterator(); 

                            Pessoa pessoa = new Pessoa();
                            listaPessoas.add(pessoa);

                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                switch (cell.getColumnIndex()) {
                                    case 0:
                                        pessoa.setNome(cell.getStringCellValue());
                                        break;
                                    case 1:
                                        pessoa.setSaldo(cell.getNumericCellValue());
                                        break;
                                }
                            }
                        }
                        break;

                    case 2: //Vendas
                        while (rowIterator.hasNext()) { 
                            Row row = rowIterator.next(); 
                            Iterator<Cell> cellIterator = row.cellIterator();

                            Venda venda = new Venda();
                            listaVendas.add(venda);

                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                switch (cell.getColumnIndex()) {
                                    case 0:
                                        venda.setData(cell.getDateCellValue());
                                        break;
                                    case 1:
                                        venda.setProduto(cell.getStringCellValue());
                                        break;
                                    case 3:
                                        venda.setValor(cell.getNumericCellValue());
                                        break;
                                }
                            }
                        }
                        break;

                    case 3: //Saldo
                        while (rowIterator.hasNext()) { 
                            Row row = rowIterator.next(); 
                            Iterator<Cell> cellIterator = row.cellIterator();                          

                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                Double sal = cell.getNumericCellValue();
                                listaSaldo.add(sal);
                            }
                        }
                        break;

                    case 4: //Log
                        while (rowIterator.hasNext()) { 
                            Row row = rowIterator.next(); 
                            Iterator<Cell> cellIterator = row.cellIterator();                         

                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                String log = cell.getStringCellValue();
                                listaLog.add(log);
                            }
                        }
                        break;
                }
                arquivo.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualiza(ArrayList lista, int planilha) {
        try (FileInputStream arquivo = new FileInputStream(new File(LINK_PLANILHA))) {
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetProdutos = workbook.getSheetAt(planilha);

            //pra limpar a planilha antes de mexer
            Iterator<Row> rowIterator = sheetProdutos.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.setBlank();
                }
            }

            int rownum = 0;
            switch (planilha) {
                case 0: //Estoque
                    ArrayList<Produto> listaPro = lista;
                    for (Produto p : listaPro) {
                        Row row = sheetProdutos.createRow(rownum++);
                        int cellnum = 0;
                        Cell codigo = row.createCell(cellnum++);
                        codigo.setCellValue(p.getCodigo());
                        Cell nome = row.createCell(cellnum++);
                        nome.setCellValue(p.getNome());
                        Cell valor = row.createCell(cellnum++);
                        valor.setCellValue(p.getValor());
                        Cell quantidade = row.createCell(cellnum++);
                        quantidade.setCellValue(p.getQuantidade());
                    }
                    break;

                case 1: //Pessoas
                    ArrayList<Pessoa> listaPe= lista;
                    for (Pessoa p : listaPe) {
                        Row row = sheetProdutos.createRow(rownum++);
                        int cellnum = 0;
                        Cell nome = row.createCell(cellnum++);
                        nome.setCellValue(p.getNome());
                        Cell sal = row.createCell(cellnum++);
                        sal.setCellValue(p.getSaldo());
                    }
                    break;

                case 2: // Vendas 
                    ArrayList<Venda> listaVe= lista;
                    for (Venda v : listaVe) {
                        Row row = sheetProdutos.createRow(rownum++);
                        int cellnum = 0;
                        Cell data = row.createCell(cellnum++);
                        data.setCellValue(v.getData());
                        Cell prod = row.createCell(cellnum++);
                        prod.setCellValue(v.getProduto());
                        Cell valor = row.createCell(cellnum++);
                        valor.setCellValue(v.getValor());
                    }
                    break;

                case 3: //Saldo - provavelmente não utilizavel
                    ArrayList<Double> listaSa= lista;
                    for (Double s : listaSa) {
                        Row row = sheetProdutos.createRow(rownum++);
                        int cellnum = 0;
                        Cell sal = row.createCell(cellnum++);
                        sal.setCellValue(s);
                    }
                    break;

                case 4: //Log - provavelmente não utilizavel
                    ArrayList<String> listaLo= lista;
                    for (String l : listaLo) {
                        Row row = sheetProdutos.createRow(rownum++);
                        int cellnum = 0;
                        Cell log = row.createCell(cellnum++);
                        log.setCellValue(l);
                    }
                    break;
            }

            arquivo.close();

            try (FileOutputStream out = new FileOutputStream(new File(Arquivo.LINK_PLANILHA))){
                workbook.write(out);
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            } catch (IOException e) {
                System.out.println("Erro na edição do arquivo!");
            }
        } catch (IOException e) {
            System.out.println("Arquivo Excel não encontrado!");
        }
    }
    
    public Produto getProduto(int cod){
        return listaProdutos.get(cod);
    }

    public ArrayList getEstoque() {
        return (ArrayList) this.listaProdutos;
    }

    public ArrayList getPessoas() {
        return (ArrayList) this.listaPessoas;
    }

    public ArrayList getSaldo() {
        return (ArrayList) this.listaSaldo;
    }
  
    public ArrayList getVendas() {
        return (ArrayList) this.listaVendas;
    }

    public ArrayList getLog() {
        return (ArrayList) this.listaLog;
    }
    
    public double getSaldoAtual(){
        ArrayList<Double> sal = getSaldo();        
        return sal.get(sal.size()-1);
    }
    
    public boolean atualizaSaldo(String nome, Double acrecimo){
        ArrayList<Pessoa> lista = getPessoas();
        for (Pessoa pessoa : lista){
            if (pessoa.getNome().equals(nome)){                
                if (pessoa.getSaldo() + acrecimo < 0){                    
                    return false;
                } else {
                    pessoa.setSaldo(pessoa.getSaldo() + acrecimo);
                    atualiza(lista, 1); //atualização das pessoas na lista                     
                    return true;
                }
            }
        }
        return false;
    }

    public void adiciona(Produto p) {
        boolean teste = false;
        ArrayList<Produto> lista = getEstoque();
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals(p.getNome())) {
                teste = true;                
            }
        }
        
        if (teste){
            erro.erro("Produto já inserido", "O produto informado já esta cadastrado no estoque", "erro");
        } else {
            p.setCodigo(lista.size() + 1);
            lista.add(p);
            atualiza(lista, 0);
            erro.erro("Adição realizada", "Adição feita com sucesso!", "info");
        }
    }
    
    public void adiciona(Pessoa p) { //Pessoa
        boolean teste = false;
        ArrayList<Pessoa> lista = getPessoas();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals(p.getNome())) {
                teste = true;
            }
        }

        if (teste) {
            erro.erro("Pessoa já cadastrada", "A pessoa informada já possui cadastro", "erro");
        } else {
            lista.add(p);
            atualiza(lista, 1); //atualização das pessoas na lista  
            erro.erro("Adição realizada", "Adição feita com sucesso!", "info");
        }
    }

    public void adiciona(Venda v) { //Venda
        ArrayList<Venda> lista = getVendas();
        lista.add(v);
        atualiza(lista, 2); 
    }
    
    public void adiciona (Double s, String sinal){ //Saldo
        ArrayList<Double> lista = getSaldo();
        switch (sinal){
            case "=":
                this.saldo = s;
                lista.add(s);
                atualiza(lista,3);
                break;
            case "+":
                this.saldo = getSaldoAtual() + s;
                lista.add(saldo);
                atualiza(lista,3);
                break;
            case "-":
                this.saldo = getSaldoAtual() - s;
                lista.add(saldo);
                atualiza(lista,3);
                break;
        }
    }

    public void adiciona(String l) { //Log
        ArrayList<String> lista = getLog();
        lista.add(l);
        atualiza(lista, 4);      
    }
    
    public void edita(Produto p){
        ArrayList<Produto> lista = getEstoque();
        for (Produto produto : lista) {
            if (p.getCodigo() == produto.getCodigo()) {
                produto = p;
            }
        }
        atualiza(lista, 0); //atualização do estoque com a edição feita
    }

    public void edita(Pessoa p, String nome){
        ArrayList<Pessoa> lista = getPessoas();
        for (Pessoa pe : lista){
            if (pe.getNome().equals(p.getNome())){
                pe.setNome(nome);
            }
        }
        atualiza(lista, 1); //atualização das pessoas na lista 
        erro.erro("Edição realizada", "Edição feita com sucesso!", "info");
    }
    
    public void remove(Produto p){
        ArrayList<Produto> lista = getEstoque();

        for (int i = 0; i < lista.size(); i++) {
            if (p.getCodigo() == lista.get(i).getCodigo()) {
                lista.remove(p);
                for (int j = i++; j < lista.size(); j++) {
                    lista.get(j).setCodigo(lista.get(j).getCodigo() - 1);
                }
                break;
            }
        }
        atualiza(lista, 0); //atualização do estoque com a edição feita
        erro.erro("Exclusão realizada", "Exclusão feita com sucesso!", "info");
    }
    
    public void remove(Pessoa p){
        ArrayList<Pessoa> lista = getPessoas();       

        for (int i = 0; i < lista.size(); i++) {
            if (p.getNome().equals(lista.get(i).getNome())) {
                lista.remove(i);
            }
        }
        atualiza(lista, 1); //atualização das pessoas na lista 
        erro.erro("Exclusão realizada", "Exclusão feita com sucesso!", "info");
    }
}
