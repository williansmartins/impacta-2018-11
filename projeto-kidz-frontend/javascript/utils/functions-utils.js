function isEmpytNullOrUndefined(valor) {
	if (typeof(valor) === "undefined" || valor === null || valor == '') {
		return true;
	}
	return false;
}



function converterValorLiteralEmFloat( num ) {
	var numero = num.toString().replace( /\./g, '');  //remover pontos de milhar
	numero = numero.toString().replace( 'R$', '');    //remover cifrão
	numero = numero.replace(/ /g,'');                 //remover espaço em branco
	numero = numero.replace( /,/g, '.');              //trocar virgulas por ponto
    return parseFloat( numero ); 					  //converter em float
}



// 13/12/2017 -> 2017-12-13
function inverterData(dataBrasil){
	return ""+dataBrasil.substring(6,12)+"-"+dataBrasil.substring(3,5)+"-"+dataBrasil.substring(0,2);
}



//yyyy-mm-dd -> Date()
function criarData(string){
	var parts = string.split("-");
	return new Date(parts[0], parts[1] - 1, parts[2]);
}

function calcularIdade(ano_aniversario, mes_aniversario, dia_aniversario){
    var d = new Date,
        ano_atual = d.getFullYear(),
        mes_atual = d.getMonth() + 1,
        dia_atual = d.getDate(),

        ano_aniversario = +ano_aniversario,
        mes_aniversario = +mes_aniversario,
        dia_aniversario = +dia_aniversario,

        quantos_anos = ano_atual - ano_aniversario;

    if (mes_atual < mes_aniversario || mes_atual == mes_aniversario && dia_atual < dia_aniversario) {
        quantos_anos--;
    }

    return quantos_anos < 0 ? 0 : quantos_anos;
}