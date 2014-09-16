package br.com.sac.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sac.domain.Horario;
import br.com.sac.domain.OperacaoEnum;
import br.com.sac.dto.EventoDTO;
import br.com.sac.dto.EventoFiltroDTO;
import br.com.sac.dto.HorarioDTO;
import br.com.sac.manager.IEventoManager;
import br.com.sac.manager.IHorarioManager;
import br.com.sac.util.SacSystemUtil;

@ManagedBean
@ViewScoped
public class CadastrarEventoMB extends AbstractMB {

	@ManagedProperty(value = "#{eventoManager}")
	private IEventoManager eventoManager;

	@ManagedProperty(value = "#{horarioManager}")
	private IHorarioManager horarioManager;

	private EventoDTO eventoDTO;
	private EventoFiltroDTO eventoFiltroDTO;
	private List<EventoDTO> eventos;
	private boolean exibirModalConfirmacaoEvento;

	@Override
	void inicializar() {
		setOperacao(OperacaoEnum.LISTAGEM);
		configurarHorarioDTO();
		configurarFiltro();
		carregarEventos();
	}

	public void validarEvento() {
		List<Horario> horarios = horarioManager.obterHorarios(eventoDTO
				.getHorarios());
		if (eventoManager.isEventoValido(eventoDTO, horarios)) {
			setExibirModalConfirmacaoEvento(true);
		}
	}

	private void configurarFiltro() {
		if (SacSystemUtil.isNull(eventoFiltroDTO)) {
			eventoFiltroDTO = new EventoFiltroDTO();
		}
	}

	private void carregarEventos() {
		if (isOperacaoListagem()) {
			eventos = eventoManager.consultarEventos(eventoFiltroDTO);
		}
	}

	public void cadastrarEvento() {
		setOperacao(OperacaoEnum.CADASTRO);
	}

	public void editarEvento() {
		setOperacao(OperacaoEnum.EDICAO);
	}

	public void excluirEvento() {
		setOperacao(OperacaoEnum.EXCLUSAO);
	}

	public void listarEventos() {
		setOperacao(OperacaoEnum.LISTAGEM);		
	}

	public void confirmarCadastrarEvento() {
		List<Horario> horarios = horarioManager.obterHorarios(eventoDTO
				.getHorarios());
		eventoManager.inserirEvento(eventoDTO, horarios);
		setOperacao(OperacaoEnum.LISTAGEM);
		carregarEventos();		
	}

	public void cancelarModal() {
		setExibirModalConfirmacaoEvento(false);
	}

	public void adicionarHorario() {
		getEventoDTO().getHorarios().add(new HorarioDTO());
	}

	public void removerHorario() {
		int quantidadeHorarios = getEventoDTO().getHorarios().size();
		if (quantidadeHorarios > 1) {
			getEventoDTO().getHorarios().remove(quantidadeHorarios - 1);
		}
	}

	public boolean isExibirListagemPanel() {
		return isOperacaoListagem();
	}

	public boolean isExibirCadastroEdicaoPanel() {
		return isOperacaoCadastro() || isOperacaoEdicao();
	}

	public boolean isExibirExclusaoModal() {
		return isOperacaoExclusao();
	}

	private void configurarHorarioDTO() {
		setEventoDTO(new EventoDTO());
	}

	public EventoDTO getEventoDTO() {
		return eventoDTO;
	}

	public void setEventoDTO(EventoDTO eventoDTO) {
		this.eventoDTO = eventoDTO;
	}

	public IEventoManager getEventoManager() {
		return eventoManager;
	}

	public void setEventoManager(IEventoManager eventoManager) {
		this.eventoManager = eventoManager;
	}

	public boolean isExibirModalConfirmacaoEvento() {
		return exibirModalConfirmacaoEvento;
	}

	public void setExibirModalConfirmacaoEvento(
			boolean exibirModalConfirmacaoEvento) {
		this.exibirModalConfirmacaoEvento = exibirModalConfirmacaoEvento;
	}

	public IHorarioManager getHorarioManager() {
		return horarioManager;
	}

	public void setHorarioManager(IHorarioManager horarioManager) {
		this.horarioManager = horarioManager;
	}

	public List<EventoDTO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoDTO> eventos) {
		this.eventos = eventos;
	}

	public EventoFiltroDTO getEventoFiltroDTO() {
		return eventoFiltroDTO;
	}

	public void setEventoFiltroDTO(EventoFiltroDTO eventoFiltroDTO) {
		this.eventoFiltroDTO = eventoFiltroDTO;
	}

}
