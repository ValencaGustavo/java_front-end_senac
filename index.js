var h1Titulo1 = document.createElement("h1");
h1Titulo1.innerText = "Titulo 1";

var elementLabel = document.createElement("Label");
elementLabel.innerText = "Label 1";

var containerDiv = document.createElement("div");
containerDiv.innerText = "Div 1"; 
containerDiv.dataset.id = "divContainer";

letVariavel = "letVar";
console.log(letVariavel)

function funcao() {
    console.log(letVariavel)
}
containerDiv.onclick = funcao;

document.body.appendChild(h1Titulo1);
document.body.appendChild(elementLabel);
document.body.appendChild(containerDiv);

export class NomeDaClasse {
    constructor (parametro1, parametro2, parametro3) {
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.parametro3 = parametro3;
    }
    exibirConsole() {
        console.log("teste");
    }
}

NomeDaClasse.exibirConsole