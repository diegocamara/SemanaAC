package br.com.sac.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.dto.UsuarioDTO;
import br.com.sac.manager.IUsuarioManager;

@ManagedBean
@RequestScoped
public class CadastrarUsuarioMB extends AbstractMB {

	@ManagedProperty(value = "#{usuarioManager}")
	private IUsuarioManager usuarioManager;

	private UsuarioDTO usuarioDTO;
	private boolean exibirModalConfirmacaoCadastro;

	@Override
	void inicializar() {		
		setUsuarioDTO(new UsuarioDTO());
		setExibirModalConfirmacaoCadastro(false);
	}

	public void cadastrarUsuario() {
		usuarioManager.cadastrarUsuario(usuarioDTO, UsuarioTipoEnum.ALUNO);
		setUsuarioDTO(new UsuarioDTO());
	}

	public void validarCadastroUsuario() {
		if(usuarioManager.isUsuarioValido(usuarioDTO)){
			setExibirModalConfirmacaoCadastro(true);			
		}
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public IUsuarioManager getUsuarioManager() {
		return usuarioManager;
	}

	public void setUsuarioManager(IUsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}

	public boolean isExibirModalConfirmacaoCadastro() {
		return exibirModalConfirmacaoCadastro;
	}

	public void setExibirModalConfirmacaoCadastro(
			boolean exibirModalConfirmacaoCadastro) {
		this.exibirModalConfirmacaoCadastro = exibirModalConfirmacaoCadastro;
	}

}
