/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Recruit.ModelRecruit;
import Model.Recruit.ModelTabelRecruit;
import Model.Recruit.RecruitDAO;
import View.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Lab Informatika
 */
public class ControllerRecruit {
    ViewRecruit_ halamanRecruit;
    RecruitDAO daoRecruit;
    
    List<ModelRecruit>daftarRecruit;
    public ControllerRecruit(ViewRecruit_ halamanRecruit){
        this.halamanRecruit = halamanRecruit;
        daoRecruit = new RecruitDAO();
    }
    
    public void showAllRecruit(){
        daftarRecruit = daoRecruit.getAll();
        ModelTabelRecruit table = new ModelTabelRecruit();
        halamanRecruit.getTabelRecruit().setModel(table);
    }
    
    public void insertRecruit(){
        try{
            ModelRecruit recruitBaru = new ModelRecruit();
            String nama = halamanRecruit.getInputNama();
            String path = halamanRecruit.getInputPath();
            int writing = halamanRecruit.getInputWriting();
            int coding = halamanRecruit.getInputCoding();
            int interview = halamanRecruit.getInputInterview();
            int score = (writing + coding + interview)/3;
            String status;
            if (score < 85) {
                status = "Tidak Lulus";
            }
            else{
                status = "Lulus";
            }
            recruitBaru.setNama(nama);
            recruitBaru.setPath(path);
            recruitBaru.setWriting(writing);
            recruitBaru.setCoding(coding);
            recruitBaru.setInterview(interview);
            recruitBaru.setScore(score);
            recruitBaru.setStatus(status);
            daoRecruit.insert(recruitBaru);
            JOptionPane.showMessageDialog(null,"Recruit Berhasil ditambahkan");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }
    
     
    public void editRecruit(int id){
        try{
            ModelRecruit recruitDiedit = new ModelRecruit();
            String nama = halamanRecruit.getInputNama();
            String path = halamanRecruit.getInputPath();
            int writing = halamanRecruit.getInputWriting();
            int coding = halamanRecruit.getInputCoding();
            int interview = halamanRecruit.getInputInterview();
            int score = (writing + coding + interview)/3;
            String status;
            if (score < 85) {
                status = "Tidak Lulus";
            }
            else{
                status = "Lulus";
            }
            recruitDiedit.setId(id);
            recruitDiedit.setNama(nama);
            recruitDiedit.setPath(path);
            recruitDiedit.setWriting(writing);
            recruitDiedit.setCoding(coding);
            recruitDiedit.setInterview(interview);
            recruitDiedit.setScore(score);
            recruitDiedit.setStatus(status);
            daoRecruit.edit(recruitDiedit);
            JOptionPane.showMessageDialog(null,"Recruit Berhasil diedit");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }
    
      public void hapusRecruit(int baris){
        try{
            int id = (int)halamanRecruit.getTabelRecruit().getValueAt(baris, 0);
            String nama = halamanRecruit.getTabelRecruit().getValueAt(baris, 1).toString();
            int input = JOptionPane.showConfirmDialog(null,"Hapus" + nama + "?",
                    "Hapus Recruit",
                    JOptionPane.YES_NO_OPTION);
            if (input ==0){
                daoRecruit.delete(id);
                JOptionPane.showMessageDialog(null,"Recruit Berhasil diahpus");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }
    
}
