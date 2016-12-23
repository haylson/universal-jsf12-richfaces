package br.com.universal.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.universal.model.Usuario;
import br.com.universal.util.JSFUtil;

public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		Usuario usuario = JSFUtil.obterUsuarioSessao();
		
		if (usuario == null && !JSFUtil.obterViewAtual().contains("login.jspx")) {
			JSFUtil.navegarLogin();
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
