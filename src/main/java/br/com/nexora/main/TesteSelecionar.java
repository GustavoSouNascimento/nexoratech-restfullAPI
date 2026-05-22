package br.com.nexora.main;

import br.com.nexora.dao.*;
import br.com.nexora.entities.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionar {
    static String texto(String t, String m) {
        return JOptionPane.showInputDialog(null, t, m, JOptionPane.QUESTION_MESSAGE);
    }

    static int inteiro(String i, String m) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, i, m, JOptionPane.QUESTION_MESSAGE));
    }

    static long longo(String l, String m) {
        return Long.parseLong(JOptionPane.showInputDialog(null, l, m, JOptionPane.QUESTION_MESSAGE));
    }

    static double real(String r, String m) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, r, m, JOptionPane.QUESTION_MESSAGE));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDao userDao = new UsuarioDao();
        VoluntarioDao volunDao = new VoluntarioDao();
        PacienteDao paciDao = new PacienteDao();
        TriagemDao triDao = new TriagemDao();
        TratamentoDao trataDao = new TratamentoDao();
        AgendamentoDao agendaDao = new AgendamentoDao();

        int usuario = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION);
        if (usuario == 0) {
            List<Usuario> listaUsuarios = (ArrayList<Usuario>) userDao.selecionar();
            if(listaUsuarios != null){
                for(Usuario user : listaUsuarios) {
                    System.out.println(
                            user.getId() + " " +
                            user.getNome() + " " +
                            user.getEmail() + " " +
                            user.getPerfil()  + " " +
                            user.getSenha()  + " "
                    );
                }
                System.out.println("\n");
            }
        }

        int voluntario = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Voluntario?", "Informações de Voluntario", JOptionPane.YES_NO_OPTION);
        if (voluntario == 0) {
            List<Voluntario> listaVoluntarios = (ArrayList<Voluntario>) volunDao.selecionar();
            if(listaVoluntarios != null){
                for(Voluntario volun : listaVoluntarios) {
                    System.out.println(
                            volun.getId() + " " +
                                    volun.getNome() + " " +
                                    volun.getEmail() + " " +
                                    volun.getCpf()  + " " +
                                    volun.getCro()  + " " +
                                    volun.getTelefone()  + " " +
                                    volun.getEmail()  + " "
                    );
                }
                System.out.println("\n");
            }
        }

        int paciente = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Paciente?", "Informações de Paciente", JOptionPane.YES_NO_OPTION);
        if (paciente == 0) {
            List<Paciente> listaPacientes = (ArrayList<Paciente>) paciDao.selecionar();
            if(listaPacientes != null){
                for(Paciente paci : listaPacientes) {
                    System.out.println(
                            paci.getId() + " " +
                            paci.getNome() + " " +
                            paci.getCpf() + " " +
                            paci.getTelefone()  + " " +
                            paci.getEmail()  + " " +
                            paci.getEndereco()  + " " +
                            paci.getDataNascimento()  + " "
                    );
                }
                System.out.println("\n");
            }
        }

        int triagem = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Triagem?", "Informações de Triagem", JOptionPane.YES_NO_OPTION);
        if (triagem == 0) {
            List<Triagem> listaTriagems = (ArrayList<Triagem>) triDao.selecionar();
            if(listaTriagems != null){
                for(Triagem tri : listaTriagems) {
                    System.out.println(
                            tri.getId() + " " +
                            tri.getPaciente() + " " +
                            tri.getUsuario() + " " +
                            tri.getDescricao()  + " " +
                            tri.getUrgencia()  + " " +
                            tri.getStatus()  + " "
                    );
                }
                System.out.println("\n");
            }
        }

        int tratamento = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Tratamento?", "Informações de Tratamento", JOptionPane.YES_NO_OPTION);
        if (tratamento == 0) {
            List<Tratamento> listaTratamentos = (ArrayList<Tratamento>) trataDao.selecionar();
            if(listaTratamentos != null){
                for(Tratamento trata : listaTratamentos) {
                    System.out.println(
                            trata.getId() + " " +
                            trata.getVoluntario() + " " +
                            trata.getPaciente() + " " +
                            trata.getDataInicio()  + " " +
                            trata.getDataConclusao()  + " " +
                            trata.getStatus()  + " "
                    );
                }
                System.out.println("\n");
            }
        }

        int agendamento = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Agendamento?", "Informações de Agendamento", JOptionPane.YES_NO_OPTION);
        if (agendamento == 0) {
            List<Agendamento> listaAgendamentos = (ArrayList<Agendamento>) agendaDao.selecionar();
            if(listaAgendamentos != null){
                for(Agendamento agenda : listaAgendamentos) {
                    System.out.println(
                            agenda.getId() + " " +
                            agenda.getVoluntario() + " " +
                            agenda.getTratamento() + " " +
                            agenda.getPaciente()  + " " +
                            agenda.getDataHora()  + " " +
                            agenda.getLocal()  + " " +
                            agenda.getStatus()  + " "
                    );
                }
                System.out.println("\n");
            }
        }
    }
}
