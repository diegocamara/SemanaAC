package br.com.sac.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sac.dao.UsuarioDAO;
import br.com.sac.domain.Usuario;
import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.dto.UsuarioDTO;
import br.com.sac.dto.UsuarioLoginDTO;
import br.com.sac.util.ConstantesMensagens;
import br.com.sac.util.SacSystemUtil;

@Service
public class UsuarioManager implements IUsuarioManager {

	private static final String CPF_REGEX_VALIDATOR = "[0-9]{11}";
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void cadastrarUsuario(UsuarioDTO usuarioDTO, UsuarioTipoEnum tipo) {
		usuarioDAO.save(obterUsuario(usuarioDTO, tipo));
		SacSystemUtil.adicionarMensagemOperacaoSucesso();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExisteEmailCadastrado(String email) {
		return usuarioDAO.isExisteEmailCadastrado(email);
	}

	@Override
	@Transactional(readOnly = true)
	public String buscarSenhaUsuarioLogin(String email) {
		return usuarioDAO.buscarSenhaUsuarioLogin(email);
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioLoginDTO buscarUsuarioLogin(String email) {
		return usuarioDAO.buscarUsuarioLogin(email);
	}

	private Usuario obterUsuario(UsuarioDTO usuarioDTO, UsuarioTipoEnum tipo) {
		Usuario usuario = new Usuario();
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setCurso(usuarioDTO.getCurso());
		usuario.setDataNascimento(usuarioDTO.getDataNascimento());
		usuario.setEmail(usuarioDTO.getEmail().trim().toLowerCase());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setTipo(tipo);
		return usuario;
	}

	@Override
	public boolean isUsuarioValido(UsuarioDTO usuarioDTO) {
		return isCamposCadastroUsuarioValidos(usuarioDTO);
	}

	@Override
	public boolean executarLogin(String email, String senha) {

		String senhaCadastrada = StringUtils.EMPTY;

		if (isExisteEmailCadastrado(email)) {
			senhaCadastrada = buscarSenhaUsuarioLogin(email);
		} else {
			SacSystemUtil
					.adicionarMensagemErro(ConstantesMensagens.MSG_ERRO_LOGIN_EMAIL_INEXISTENTE);
		}

		if (StringUtils.isNotBlank(senhaCadastrada)
				&& StringUtils.isNotBlank(senha)
				&& senha.equals(senhaCadastrada)) {
			return true;
		} else {
			SacSystemUtil
					.adicionarMensagemErro(ConstantesMensagens.MSG_ERRO_LOGIN_SENHA_INVALIDA);
			return false;
		}

	}

	private boolean isCamposCadastroUsuarioValidos(UsuarioDTO usuarioDTO) {

		List<FacesMessage> mensagens = new ArrayList<FacesMessage>();

		validarCamposPreenchidos(mensagens, usuarioDTO);
		validarCamposEmail(mensagens, usuarioDTO);
		validarCamposSenha(mensagens, usuarioDTO);

		if (mensagens.size() == 0) {
			return true;
		} else {
			SacSystemUtil.adicionarMensagensErro(mensagens);
			return false;
		}
	}

	private void validarCamposPreenchidos(List<FacesMessage> mensagens,
			UsuarioDTO usuarioDTO) {
		if (StringUtils.isEmpty(usuarioDTO.getNome())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CAMPO_NOME_NAO_PREENCHIDO));
		}
		if (StringUtils.isEmpty(usuarioDTO.getCpf())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CAMPO_CPF_NAO_PREENCHIDO));
		}
		if (StringUtils.isEmpty(usuarioDTO.getEmail())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CAMPO_EMAIL_PREENCHIDO));
		}
		if (StringUtils.isEmpty(usuarioDTO.getCurso())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CAMPO_CURSO_NAO_PREENCHIDO));
		}
		if (StringUtils.isEmpty(usuarioDTO.getSenha())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CAMPO_SENHA_NAO_PREENCHIDO));
		}
		if (SacSystemUtil.isNull(usuarioDTO.getDataNascimento())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_DATA_NASCIMENTO_NULA));
		}

		validarCpf(mensagens, usuarioDTO.getCpf());

	}

	private void validarCamposEmail(List<FacesMessage> mensagens,
			UsuarioDTO usuarioDTO) {

		if (SacSystemUtil.isNotNull(usuarioDTO.getEmail())
				&& SacSystemUtil.isNotNull(usuarioDTO.getEmailRepetido())
				&& !usuarioDTO.getEmail().equalsIgnoreCase(
						usuarioDTO.getEmailRepetido())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_EMAILS_DIFERENTES));
		} else {
			validarEmail(mensagens, usuarioDTO.getEmail().toLowerCase().trim());
		}

	}

	private void validarCamposSenha(List<FacesMessage> mensagens,
			UsuarioDTO usuarioDTO) {
		if (SacSystemUtil.isNotNull(usuarioDTO.getSenha())
				&& SacSystemUtil.isNotNull(usuarioDTO.getSenhaRepetida())
				&& !usuarioDTO.getSenha().equals(usuarioDTO.getSenhaRepetida())) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_SENHAS_DIFERENTES));
		}
	}

	private void validarEmail(List<FacesMessage> mensagens, String email) {
		if (StringUtils.isNotEmpty(email) && isExisteEmailCadastrado(email)) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_EMAIL_JA_CADASTRADO));
		}
	}

	private void validarCpf(List<FacesMessage> mensagens, String cpf) {

		if (StringUtils.isNotEmpty(cpf)) {

			Pattern pattern = Pattern.compile(CPF_REGEX_VALIDATOR);
			Matcher matcher = pattern.matcher(cpf);

			if (!matcher.matches()) {
				mensagens
						.add(SacSystemUtil
								.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_CPF_INVALIDO));
			}

		}
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
