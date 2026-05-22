package br.com.nexora.main;

import br.com.nexora.dao.*;
import br.com.nexora.entities.*;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletar {
    static int inteiro(String i) {
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

        int usuario = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION);
        if (usuario == 0) {
            do{
                objUsuario.setId(inteiro("Informe o ID do Usuario a ser deletado"));
                System.out.println(userDao.deletar(objUsuario.getId()));
            } while( JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações de Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int voluntario = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Voluntario?", "Informações de Voluntario", JOptionPane.YES_NO_OPTION);
        if (voluntario == 0) {
            do {
                objVoluntario.setId(inteiro("Informe o ID do Voluntario a ser deletado"));
                System.out.println(volunDao.deletar(objVoluntario.getId()));
            } while (JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações de Voluntario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int paciente = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Paciente?", "Informações de Paciente", JOptionPane.YES_NO_OPTION);
        if (paciente == 0) {
            do {
                objPaciente.setId(inteiro("Informe o ID da Paciente a ser deletado"));
                System.out.println(paciDao.deletar(objPaciente.getId()));
            } while (JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações para Paciente?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int triagem = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Triagem?", "Informações de Triagem", JOptionPane.YES_NO_OPTION);
        if (triagem == 0) {
            do{
                objTriagem.setId(inteiro("Informe o ID da Triagem a ser deletado"));
                System.out.println(triDao.deletar(objTriagem.getId()));
            } while( JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações para Triagem?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int tratamento = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Tratamento?", "Informações de Tratamento", JOptionPane.YES_NO_OPTION);
        if (tratamento == 0) {
            do {
                objTratamento.setId(inteiro("Informe o ID da Tratamento a ser deletado"));
                System.out.println(trataDao.deletar(objTratamento.getId()));
            } while (JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações para Tratamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int agendamento = JOptionPane.showConfirmDialog(null, "Deseja deletar informações de Agendamento?", "Informações de Agendamento", JOptionPane.YES_NO_OPTION);
        if (agendamento == 0) {
            do {
                objAgendamento.setId(inteiro("Informe o ID da Agendamento a ser deletado"));
                System.out.println(agendaDao.deletar(objAgendamento.getId()));
            } while (JOptionPane.showConfirmDialog(null, "Deseja deletar mais informações para Agendamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }
    }
}
