package br.com.nexora.main;

import br.com.nexora.dao.*;
import br.com.nexora.entities.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesteInserir {
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

        int usuario = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Usuario?", "Informações de Usuario", JOptionPane.YES_NO_OPTION);
        if (usuario == 0) {
            do{
                String[] userAlt = { "Admin", "Operador", "Leitura" };
                objUsuario.setId(inteiro("ID", "Cadastro de Usuario"));
                objUsuario.setNome(texto("Nome", "Cadastro de Usuario"));
                objUsuario.setEmail(texto("Email", "Cadastro de Usuario"));
                var perfil = JOptionPane.showOptionDialog(null, "Qual o tipo de perfil?", "Tipo de Perfil", 0, 3, null, userAlt, userAlt[0]);
                if (perfil == 0) {
                    objUsuario.setPerfil("Admin");
                }
                if (perfil == 1) {
                    objUsuario.setPerfil("Operador");
                }
                if (perfil == 2) {
                    objUsuario.setPerfil("Leitura");
                }
                objUsuario.setSenha(texto("Senha", "Cadastro de Usuario"));

                userDao.inserir(objUsuario);
            }while( JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Usuario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int voluntario = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Voluntario?", "Informações de Voluntario", JOptionPane.YES_NO_OPTION);
        if (voluntario == 0) {
            do{
                objVoluntario.setId(inteiro("ID", "Cadastro de Voluntario"));
                objVoluntario.setNome(texto("Nome", "Cadastro de Voluntario"));
                objVoluntario.setCpf(longo("CPF", "Cadastro de Voluntario"));
                objVoluntario.setCro(texto("CRO", "Cadastro de Voluntario"));
                objVoluntario.setTelefone(texto("Telefone", "Cadastro de Voluntario"));
                objVoluntario.setEmail(texto("Email", "Cadastro de Voluntario"));

                volunDao.inserir(objVoluntario);
            }while( JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Voluntario?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int paciente = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Paciente?", "Informações de Paciente", JOptionPane.YES_NO_OPTION);
        if (paciente == 0) {
            do{
                String[] paciAlt = { "Ativo", "Em Andamento", "Inativo" };
                objPaciente.setId(inteiro("ID", "Cadastro de Paciente"));
                objPaciente.setNome(texto("Nome", "Cadastro de Paciente"));
                objPaciente.setCpf(longo("CPF", "Cadastro de Paciente"));
                objPaciente.setTelefone(texto("Telefone", "Cadastro de Paciente"));
                objPaciente.setEmail(texto("Email", "Cadastro de Paciente"));
                objPaciente.setEndereco(texto("Endereço", "Cadastro de Paciente"));
                objPaciente.setDataNascimento(texto("Data de Nascimento", "Cadastro de Paciente"));

                var status = JOptionPane.showOptionDialog(null, "Qual o status do Paciente?", "Tipo de Paciente", 0, 3, null, paciAlt, paciAlt[0]);
                if (status == 0) {
                    objPaciente.setStatus("Ativo");
                }
                if (status == 1) {
                    objPaciente.setStatus("Em_Andamento");
                }
                if (status == 2) {
                    objPaciente.setStatus("Inativo");
                }

                paciDao.inserir(objPaciente);
            }while( JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Paciente?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int triagem = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Triagem?", "Informações de Triagem", JOptionPane.YES_NO_OPTION);
        if (triagem == 0) {
            do{
                String[] triUrgAlt = { "Alta", "Baixa", "Media" };
                String[] triStatsAlt = { "Cancelada", "Concluida", "Pendente" };
                objTriagem.setId(inteiro("ID", "Cadastro de Triagem"));
                objTriagem.setPaciente(inteiro("ID do Paciente", "Cadastro de Triagem"));
                objTriagem.setUsuario(inteiro("ID do Usuario", "Cadastro de Triagem"));
                objTriagem.setDescricao(texto("Descrição", "Cadastro de Triagem"));
                var urgencia = JOptionPane.showOptionDialog(null, "Qual a urgencia da Triagem?", "Urgencia de Triagem", 0, 3, null, triUrgAlt, triUrgAlt[0]);
                if (urgencia == 0) {
                    objTriagem.setUrgencia("Alta");
                }
                if (urgencia == 1) {
                    objTriagem.setUrgencia("Baixa");
                }
                if (urgencia == 2) {
                    objTriagem.setUrgencia("Media");
                }

                var status = JOptionPane.showOptionDialog(null, "Qual o status do Triagem?", "Status de Triagem", 0, 3, null, triStatsAlt, triStatsAlt[0]);
                if (status == 0) {
                    objTriagem.setStatus("Cancelada");
                }
                if (status == 1) {
                    objTriagem.setStatus("Concluida");
                }
                if (status == 2) {
                    objTriagem.setStatus("Pendente");
                }

                triDao.inserir(objTriagem);
            }while( JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Triagem?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int tratamento = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Tratamento?", "Informações de Tratamento", JOptionPane.YES_NO_OPTION);
        if (tratamento == 0) {
            do {
                String[] trataAlt = {"Concluido", "Em andamento", "Cancelado"};
                objTratamento.setId(inteiro("ID", "Cadastro de Tratamento"));
                objTratamento.setVoluntario(inteiro("ID do Voluntario", "Cadastro de Tratamento"));
                objTratamento.setPaciente(inteiro("ID do Paciente", "Cadastro de Tratamento"));
                objTratamento.setDataInicio(texto("Data de Inicio do Tratamento", "Cadastro de Tratamento"));
                objTratamento.setDataConclusao(texto("Data de Finalização do Tratamento", "Cadastro de Tratamento"));
                var status = JOptionPane.showOptionDialog(null, "Qual o status do Tratamento?", "Status de Tratamento", 0, 3, null, trataAlt, trataAlt[0]);
                if (status == 0) {
                    objTratamento.setStatus("Concluido");
                }
                if (status == 1) {
                    objTratamento.setStatus("Em_Andamento");
                }
                if (status == 2) {
                    objTratamento.setStatus("Cancelado");
                }

                trataDao.inserir(objTratamento);
            } while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Tratamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }

        int agendamento = JOptionPane.showConfirmDialog(null, "Deseja adicionar informações de Agendamento?", "Informações de Agendamento", JOptionPane.YES_NO_OPTION);
        if (agendamento == 0) {
            do {
                String[] agendaAlt = {"Agendado", "Realizado", "Cancelado"};
                objAgendamento.setId(inteiro("ID", "Cadastro de Agendamento"));
                objAgendamento.setVoluntario(inteiro("ID do Voluntario", "Cadastro de Agendamento"));
                objAgendamento.setTratamento(inteiro("ID do Tratamento", "Cadastro de Agendamento"));
                objAgendamento.setPaciente(inteiro("ID do Paciente", "Cadastro de Agendamento"));
                objAgendamento.setDataHora(texto("Data do Agendamento", "Cadastro de Agendamento"));
                objAgendamento.setLocal(texto("Local de Atendimento", "Cadastro de Agendamento"));
                var status = JOptionPane.showOptionDialog(null, "Qual o status do Agendamento?", "Status de Agendamento", 0, 3, null, agendaAlt, agendaAlt[0]);
                if (status == 0) {
                    objAgendamento.setStatus("Agendado");
                }
                if (status == 1) {
                    objAgendamento.setStatus("Realizado");
                }
                if (status == 2) {
                    objAgendamento.setStatus("Cancelado");
                }
                objAgendamento.setObservacao(texto("Observações", "Cadastro de Agendamento"));

                agendaDao.inserir(objAgendamento);
            } while (JOptionPane.showConfirmDialog(null, "Deseja adicionar mais informações para Agendamento?", "Nexoratech", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        }
    }
}
