
function formataCampoMonetario(obj) {
	// Esta funcao formata campos monetarios. Deve ser chamada em um capo text
	// da seguinte forma
	// ela trabalha em conjunto com a funcao getMilhar
	// onkeyup="JavaScript formataCampoMonetario(this);"
	var regrenpontos = new RegExp("[,.]+", "g");
	var regrenZeros = new RegExp("^0+", "g");
	a = obj.value;
	// Aqui removemos os . , e zeros a esquerda.
	a = a.replace(regrenpontos, "");
	a = a.replace(regrenZeros, "");

	if (a.length >= 3) {
		obj.value = getMilhar(a.substr(0, a.length - 2)) + ","
				+ a.substr(a.length - 2, a.length - 1);
	} else if (a.length == 2) {
		obj.value = "0," + a;
	} else if (a.length == 1) {
		obj.value = "0,0" + a;
	} else {
		obj.value = "0,00";
	}

}

function getMilhar(valor) {
	// Esta funcao formata campos numericos com pontos de milhar.

	var vetor = new Array();
	var retorno = "";
	while (valor.length > 3) {
		vetor.push(valor.substr(valor.length - 3, valor.length - 1));
		valor = valor.substr(0, valor.length - 3);
	}

	if (vetor.length >= 2) {
		vetor.reverse();
		retorno = vetor.join(".");
		if (valor.length > 0) {
			retorno = valor + "." + retorno;
		}
	} else if (vetor.length == 1) {
		retorno = vetor[0];
		if (valor.length > 0) {
			retorno = valor + "." + retorno;
		}
		return retorno;
	} else {
		return valor;
	}
	return retorno;
}

function getEvento(evento) {
	// Funcao retorna o codigo ascii do evento de teclado
	// verifica se estamso trabalhando com firefox ou ie
	codigo = evento.keyCode;
	if (codigo == 0) {
		codigo = evento.charCode;
	}
	return (codigo);

}
function campoNumerico(evento) {
	// Funcao verifica se o valor e numerico ou nao;
	// esta deve ser chamada atravez de um onkeypress do javascript da seguinte
	// forma:
	// onkeypress="java script:return campoNumerico(event);"
	codigo = getEvento(evento);
	if ((codigo > 46 && codigo < 58) || (codigo > 37 && codigo < 41)
			|| (codigo == 8 || codigo == 9)) {
		return true;
	}
	return false;
}

function formatar_mascara(src, mascara) {
    //EXEMPLOS:	
    //CPF: XXX.XXX.XXX-XX
    //CNPJ: XX.XXX.XXX/XXXX-XX
    //TEL: (XX) XXXX-XXXX
    //DATA: DD/MM/YYYY
    var campo = src.value.length;
    var saida = mascara.substring(0,1);
    var texto = mascara.substring(campo);
    if(texto.substring(0,1) != saida) {
	src.value += texto.substring(0,1);
    }
}

/**
 * This function handles the radio button click action. When a radio button is 
 * clicked, set this button to selected state and all others to unselected and
 * then highlight the selected row.
 */
function radiobuttonClick(thisObj, thisEvent, nameForm, nameTable, idRadioGroup) {
  var form = document.getElementById(nameForm);
  var firstRadioButtonName = nameForm + ":"  + nameTable + ":" + 0 + ":" + idRadioGroup;
  var isInDatatable = false;
  var rowId = -1;
  for(i=0; i<form.elements.length; i++){
    if(form.elements[i].name == firstRadioButtonName){
      isInDatatable = true;
    }
    if(isInDatatable == true){
      rowId = rowId+1;
    }
    radioButtonName = nameForm + ":" + nameTable + ":"+rowId+":" + idRadioGroup;
    //Deselect all radio buttons first(if this element is a radio button inside your datatable)
    if(form.elements[i].name == radioButtonName){ 
       form.elements[i].checked = false;
       getRow(form.elements[i]).className = "";
    }      
  }
  thisObj.checked = true;                       //set this radio button to selected state
  getRow(thisObj).className = "rowHighlighted"; //highlight the selected row
}
/**
 * This function returns the table row of the given radio button element
 * for the purpose of highlighting the row.
 */
function getRow(element){
  currentRow = element.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
  return currentRow;
}

 

function exibeJanela(destino , titulo , w , h) {
	
    parent.document.getElementById('carregandoAjax').style.display = '';
	parent.document.getElementById('conteudoCarregandoAjax').style.display = '';
	parent.document.getElementById('tituloJanela').innerHTML = "<strong>" + titulo + "</strong>";

	var oDiv = parent.document.getElementById('conteudoJanelaDocumento');

	
	oDiv.style.height =  h + "px";
	oDiv.style.width  =  w + "px";
	
	
	var Ogeral = parent.document.getElementById('carregandoAjax');
	
	var left = Ogeral.offsetWidth/2 - oDiv.offsetWidth/2;
	var top  = Ogeral.offsetHeight/3  - oDiv.offsetHeight/2.5;

	oDiv.style.left   =  left + "px";
    oDiv.style.top    =  top  + "px";

    
	var iFrame = parent.document.getElementById('visualizarDocumento');
	iFrame.src = destino;
	
	select_show('oculta'); 
		
}

function fechaJanela(){
	
    parent.document.getElementById('carregandoAjax').style.display = 'none';
	parent.document.getElementById('conteudoCarregandoAjax').style.display = 'none';
	parent.document.getElementById('visualizarDocumento').src="";
	
	select_show('exibe');
}


//Array criado para armazenar a listagem de combos contidas na tela
var listCombos = new Array();

function select_show(param) {
	
	if(navigator.appName == 'Microsoft Internet Explorer') {
	
		if(param == 'oculta'){
			
			var count = 0;
			
			for(i=0; i < document.forms.length; i++) {
				
				for(j=0; j < document.forms[i].elements.length; j++) {
					
					if(document.forms[i].elements[j].type == 'select-multiple'
						|| document.forms[i].elements[j].type == 'select-one'){
						
						listCombos[count++] = document.forms[i].elements[j];
						document.forms[i].elements[j].style.visibility = 'hidden';
					}
				}
			}
			
		}
		
		if(param == 'exibe'){
			
			for (i = 0; i < listCombos.length; i++) {
				listCombos[i].style.visibility = 'visible';
			}
		}
	}
}

/**
 * Método responsável por criar um evento para determindado
 * objeto. Foi testado para criar o evento de click em um
 * link (Solução cross-browser). * Exemplo de chamada a função: fireEvent(document.getElementById("id_link"),'click');
 * 
 * @author Tiago Rolinha
 * @since 06/08/2008
 * @param obj O objeto em que será criado o evento
 * @param evt O evento que será criado
 */
function fireEvent(obj,evt){
	var fireOnThis = obj;
	if( document.createEvent ) {
		var evObj = document.createEvent('MouseEvents');
		evObj.initEvent( evt, true, false );
		fireOnThis.dispatchEvent(evObj);
	} else if( document.createEventObject ) {
		fireOnThis.fireEvent('on'+evt);
	}
}

/**
 * Método DWR que é responsável por verificar o Status da OS
 * antes de passar para o próximo
 * 
 * @param botao O objeto botao
 * @param idOs O id da Ordem de Serviço
 * @param status O status da OS
 * @param nomeBotaoAcao O nome botao que representa a ação
 */
function verificaStatusOS(botao, idOs, status, nomeBotaoAcao) {
	OrdemServicoFacadeDWR.verificaStatusOS(idOs, status,  
		function(permitir) {
		if(permitir){
			var idBotao = botao.id;
			
			var idForm = idBotao.split(':')[0];
			var idTable = idBotao.split(':')[1];
			var numLinha = idBotao.split(':')[2];
			
			var idFormatado = idForm + ":" + idTable + ":" + numLinha + ":" + nomeBotaoAcao;
			
			document.getElementById(idFormatado).click();
		}
		else{
			Richfaces.showModalPanel("modalPanelMensagem");
		}	
	  });

}



/**
 * Método que é responsável por 
 * 
 * @param idComboBaseAtendimento O id do comboBaseAtendimento 
 * @param idComboUsuario O id do comboUsuario
 * @param idBotao O id do botao que será clicado 
 * @param idDivMensagem O id da divMensagem
 */
function validaCombosFormTecnicoVinculadoProduto(idComboBaseAtendimento, idComboUsuario, idBotao, idDivMensagem) {

	var indexComboBaseAtendimento = document.getElementById(idComboBaseAtendimento).selectedIndex;
	var indexComboUsuario = document.getElementById(idComboUsuario).selectedIndex;
	
	if(indexComboBaseAtendimento == 0 || indexComboUsuario == 0){
		document.getElementById(idDivMensagem).innerHTML = 'Favor preencher todos os campos obrigatórios';
	}else{
		document.getElementById(idDivMensagem).innerHTML = '';
		document.getElementById(idBotao).click();
	}
	
	
}

/**
 * Método que é responsável por validar o combo de usuario
 * 
 * @param idComboUsuario O id do comboUsuario
 * @param idBotao O id do botao que será clicado 
 * @param idDivMensagem O id da divMensagem
 */
function validaCombosPerfilAgendador(idComboUsuario,idBotao, idDivMensagem) {

	var indexComboUsuario = document.getElementById(idComboUsuario).selectedIndex;
	
	if(indexComboUsuario == 0){
		document.getElementById(idDivMensagem).innerHTML = 'Favor Selecionar o Consultor';
	}else{
		document.getElementById(idDivMensagem).innerHTML = '';
		document.getElementById(idBotao).click();
	}
	
	
}

/**
 * Método que é responsável por simular um click no botão.
 * Foi necessário, pois o onchange do combo não enviava os produtos
 * do usuario (produtoSelecionados).
 * 
 * 
 * @param idBotao O id do botao que será clicado
 */
function atualizaProdutoDisponiveis(idBotao){
	document.getElementById(idBotao).click();
}


/**
 * Método que é responsável por displayar o timer na jspx.
 * TODO:TENTAR DEIXAR GENERICO 
 * 
 */

var sHors = "0"+0; 
var sMins = "0"+0;
var sSecs = -1;

function exibeRelogio(idForm){
	
	var clock = document.getElementById(idForm + ':clock');
	
	sSecs++;
	
	if(sSecs==60){
		sSecs=0;
		sMins++;
		if(sMins<=9){
			sMins="0"+sMins;
		}
	}
	
	if(sMins==60){
		sMins="0"+0;
		sHors++;
		if(sHors<=9){
			sHors="0"+sHors;
		}
	}
	
	if(sSecs<=9){
		sSecs="0"+sSecs;
	}
	
	clock.innerHTML=sHors+":"+sMins+":"+sSecs;
	
	var funcao = 'exibeRelogio("'+ idForm + '")';
	
	setTimeout(funcao,1000);
}

function showMessageGlobalErrorSystem(){
	window.location = "/projeto/pages/indexError.jsf";
}

