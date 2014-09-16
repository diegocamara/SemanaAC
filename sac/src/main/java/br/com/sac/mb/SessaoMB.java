package br.com.sac.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.dto.UsuarioLoginDTO;
import br.com.sac.manager.IUsuarioManager;
import br.com.sac.util.ConstantesPages;
import br.com.sac.util.PaginasUtil;
import br.com.sac.util.SacSystemUtil;

@ManagedBean
@SessionScoped
public class SessaoMB {

	@ManagedProperty(value = "#{usuarioManager}")
	private IUsuarioManager usuarioManager;

	private UsuarioLoginDTO usuarioLoginDTO;
	private String email;
	private String senha;

	public boolean isAdministrador() {
		return SacSystemUtil.isNotNull(usuarioLoginDTO)
				&& usuarioLoginDTO.isAdministrador();
	}

	public boolean isUsuarioLogado() {
		return SacSystemUtil.isNotNull(usuarioLoginDTO);	
	}

	public String entrar() {
		boolean isDadosValidos = usuarioManager.executarLogin(email, senha);
		if (isDadosValidos) {
			usuarioLoginDTO = usuarioManager.buscarUsuarioLogin(email);
			return PaginasUtil
					.getPageWithRedirect(ConstantesPages.PAGINA_INICIAL);
		} else {
			setUsuarioLoginDTO(null);
			return StringUtils.EMPTY;
		}
	}

	public String sair(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return PaginasUtil.getPageWithRedirect(ConstantesPages.PAGINA_INICIAL);
	}
	
	public String cadastrarEventos(){
		return PaginasUtil.getPageWithRedirect(ConstantesPages.PAGINA_CADASTRAR_EVENTOS);
	}
	
	public String logarAdministrador() {
		usuarioLoginDTO = new UsuarioLoginDTO();
		usuarioLoginDTO.setId(1);
		usuarioLoginDTO.setNome("Admin");
		usuarioLoginDTO.setTipo(UsuarioTipoEnum.ADMINISTRADOR);
		return PaginasUtil
				.getPageWithRedirect(ConstantesPages.PAGINA_INICIAL);
	}
	
	public String logarUsuario(){
		usuarioLoginDTO = new UsuarioLoginDTO();
		usuarioLoginDTO.setId(1);
		usuarioLoginDTO.setNome("User");
		usuarioLoginDTO.setTipo(UsuarioTipoEnum.ALUNO);
		return PaginasUtil
				.getPageWithRedirect(ConstantesPages.PAGINA_INICIAL);
	}

	public UsuarioLoginDTO getUsuarioLoginDTO() {
		return usuarioLoginDTO;
	}

	public void setUsuarioLoginDTO(UsuarioLoginDTO usuarioLoginDTO) {
		this.usuarioLoginDTO = usuarioLoginDTO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public IUsuarioManager getUsuarioManager() {
		return usuarioManager;
	}

	public void setUsuarioManager(IUsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}

}
