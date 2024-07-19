console.clear();
console.log("Hello world!");
console.error("Mensagem de Erro");

var h1Titulo1 = document.createElement("h1");
h1Titulo1.innerText = "Titulo 1";

var varVariavel = "É uma variável que pode ser alterada e usada em todo ambiente/interface";
console.log("varVariavel: ", varVariavel);

const constVariavel = "É uma variável somente leitura, a qual não poderá ser alterada, ocasionando um erro no console";
console.log("constVariavel: ", constVariavel);

let letVariavel = "É uma variável que será declarada apenas no mesmo bloco de código e logo em seguida será eliminada a memória/interface";
console.log("letVariavel: ",letVariavel);

// Alteração 

varVariavel = "Nesta linha a variável varVariavel poderá ser alterada";

letVariavel = "Nesta linha a variável letVariavel poderá ser alterada pois ainda não encerrou o bloco de códigos";

constVariavel = "Esta linha não será executada, pois a variável constVariavel é somente leitura"


console.log("varVariavel: ", varVariavel);
console.log("constVariavel: ", constVariavel);
console.log("letVariavel: ",letVariavel);

document.body.appendChild(h1Titulo1);