package br.com.nexora.main;

import br.com.nexora.dao.*;
import br.com.nexora.entities.*;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarId {
    static int inteiro(String i){
        return Integer.parseInt(JOptionPane.showInputDialog(i));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Usuario objUsuario = new Usuario();
        UsuarioDao userDao = new UsuarioDao();
        Voluntario objVoluntario = new Voluntario();
        VoluntarioDao volunDao = new VoluntarioDao();
        Paciente objPaciente = new Paciente();
        PacienteDao paciDao = new PacienteDao();
        Triagem objTriagem = new Triagem();
        TriagemDao triDao = new TriagemDao();
        Tratamento objTratamento = new Tratamento();
        TratamentoDao trataDao = new TratamentoDao();
        Agendamento objAgendamento = new Agendamento();
        AgendamentoDao agendaDao = new AgendamentoDao();

        int usuario = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION);
        if (usuario == 0) {
            do{
                objUsuario.setId(inteiro("Informe o ID do Usuario para consulta"));
                Usuario resultado = userDao.buscarId(objUsuario.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objUsuario.getId() + " não encontrado no banco de dados.");
                }
            } while( JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações de Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int voluntario = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Voluntario?", "Informações de Voluntario", JOptionPane.YES_NO_OPTION);
        if (voluntario == 0) {
            do {
                objVoluntario.setId(inteiro("Informe o ID do Voluntario para consulta"));
                Voluntario resultado = volunDao.buscarId(objVoluntario.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objVoluntario.getId() + " não encontrado no banco de dados.");
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações de Voluntario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int paciente = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Paciente?", "Informações de Paciente", JOptionPane.YES_NO_OPTION);
        if (paciente == 0) {
            do {
                objPaciente.setId(inteiro("Informe o ID do Paciente para consulta"));
                Paciente resultado = paciDao.buscarId(objPaciente.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objPaciente.getId() + " não encontrado no banco de dados.");
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações para Paciente?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int triagem = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Triagem?", "Informações de Triagem", JOptionPane.YES_NO_OPTION);
        if (triagem == 0) {
            do{
                objTriagem.setId(inteiro("Informe o ID do Triagem para consulta"));
                Triagem resultado = triDao.buscarId(objTriagem.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objTriagem.getId() + " não encontrado no banco de dados.");
                }
            } while( JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações para Triagem?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int tratamento = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Tratamento?", "Informações de Tratamento", JOptionPane.YES_NO_OPTION);
        if (tratamento == 0) {
            do {
                objTratamento.setId(inteiro("Informe o ID do Tratamento para consulta"));
                Tratamento resultado = trataDao.buscarId(objTratamento.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objTratamento.getId() + " não encontrado no banco de dados.");
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações para Tratamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int agendamento = JOptionPane.showConfirmDialog(null, "Deseja Visualizar informações de Agendamento?", "Informações de Agendamento", JOptionPane.YES_NO_OPTION);
        if (agendamento == 0) {
            do {
                objAgendamento.setId(inteiro("Informe o ID do Agendamento para consulta"));
                Agendamento resultado = agendaDao.buscarId(objAgendamento.getId());
                if (resultado != null) {
                    System.out.println(resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "ID " + objAgendamento.getId() + " não encontrado no banco de dados.");
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja Visualizar mais informações para Agendamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }
    }
}
