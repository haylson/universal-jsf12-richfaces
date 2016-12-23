function dataHora(comp) {
	data = new Date();
	dia = data.getDate();
	mes = data.getMonth();
	ano = data.getFullYear();
	
	var compReal = document.getElementById(comp);
	compReal.innerHTML = (dia + "/" + (mes + 1) + "/" + ano);

}

function relogio(comp){
	data = new Date();
    hora = data.getHours();
    minuto = data.getMinutes();
    segundo = data.getSeconds();
    dia = data.getDate();
	mes = data.getMonth();
	ano = data.getFullYear();
    
    str_segundo = new String (segundo);
	if (str_segundo.length == 1) 
		segundo = "0" + segundo;
		
	str_minuto = new String (minuto);
	if (str_minuto.length == 1) 
		minuto = "0" + minuto;

	str_hora = new String (hora);
	if (str_hora.length == 1) 
		hora = "0" + hora;
    
    var compReal = document.getElementById(comp);

    compReal.innerHTML =  (dia + "/" + (mes + 1) + "/" + ano + " " + hora + ":" + minuto);

    setTimeout("relogio('relogio')",60000);
}

