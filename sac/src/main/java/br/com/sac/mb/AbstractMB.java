package br.com.sac.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import br.com.sac.domain.OperacaoEnum;
import br.com.sac.util.SacSystemUtil;

public abstract class AbstractMB {

	@ManagedProperty(value = "#{sessaoMB}")
	private SessaoMB sessaoMB;

	private OperacaoEnum operacao;

	@PostConstruct
	abstract void inicializar();

	public boolean isOperacaoListagem() {
		return SacSystemUtil.isNotNull(getOperacao())
				&& OperacaoEnum.LISTAGEM.equals(getOperacao());
	}
	
	public boolean isOperacaoCadastro() {
		return SacSystemUtil.isNotNull(getOperacao())
				&& OperacaoEnum.CADASTRO.equals(getOperacao());
	}
	
	public boolean isOperacaoEdicao() {
		return SacSystemUtil.isNotNull(getOperacao())
				&& OperacaoEnum.EDICAO.equals(getOperacao());
	}
	
	public boolean isOperacaoExclusao() {
		return SacSystemUtil.isNotNull(getOperacao())
				&& OperacaoEnum.EXCLUSAO.equals(getOperacao());
	}

	public SessaoMB getSessaoMB() {
		return sessaoMB;
	}

	public void setSessaoMB(SessaoMB sessaoMB) {
		this.sessaoMB = sessaoMB;
	}

	public OperacaoEnum getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoEnum operacao) {
		this.operacao = operacao;
	}

}
