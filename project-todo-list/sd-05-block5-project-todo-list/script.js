let textInput = document.getElementById("texto-tarefa");
let criarTarefaBut = document.getElementById("criar-tarefa");
let apagarTudoBut = document.getElementById("apaga-tudo");
let removerFinalizadosBut = document.getElementById("remover-finalizados");
let salvarTarefasBut = document.getElementById("salvar-tarefas");
let moverBaixoBut = document.getElementById("mover-baixo");
let moverCimaBut = document.getElementById("mover-cima");
let removerSelecBut = document.getElementById("remover-selecionado");
let paiLista = document.getElementById("lista-tarefas");

//CRIAR TAREFA
criarTarefaBut.addEventListener("click", TextAdd);

function TextAdd() {
  textInput = document.getElementById("texto-tarefa");
  let textOutput = document.createElement("li");
  let lista = document.getElementsByTagName("li");
  for (i = lista.length; i <= lista.length; i++) {
    textOutput.style.backgroundColor = "white";
  }
  textOutput.innerHTML = textInput.value;
  textInput.value = "";
  paiLista.appendChild(textOutput);
}

//BACKGROUND CHANGE

paiLista.addEventListener("click", backgroundChange);
function backgroundChange(event) {
  let target = event.target;
  let corAtual = target.style.backgroundColor;
  if (corAtual === "white") {
    target.style.backgroundColor = "rgb(128,128,128)";
    target.classList.add("selected");
  } else {
    let target = event.target;
    target.style.backgroundColor = "white";
    target.classList.remove("selected");
  }
}

//LINETHROUGH

paiLista.addEventListener("dblclick", lineThrough);

function lineThrough(event) {
  let target = event.target;
  let atual = target.style.textDecoration;
  if (atual === "" || atual === "none") {
    target.classList.add("completed");
    target.style.textDecoration = "line-through";
  } else {
    target = event.target;
    target.classList.remove("completed");
    target.style.textDecoration = "none";
  }
}

//APAGA TUDO
apagarTudoBut.addEventListener("click", apagaTudo);
function apagaTudo() {
  let apagarLi = document.getElementsByTagName("li");
  for (i = apagarLi.length - 1; i >= 0; i -= 1) {
    paiLista.removeChild(apagarLi[i]);
  }
}

//APAGA FINALIZADOS
removerFinalizadosBut.addEventListener("click", apagaFinaliza);
function apagaFinaliza() {
  let apagar = document.getElementsByClassName("completed");
  for (i = apagar.length - 1; i >= 0; i -= 1) {
    paiLista.removeChild(apagar[i]);
  }
}

//APAGAR SELECIONADOS
removerSelecBut.addEventListener("click", apagaSelec);
function apagaSelec() {
  let apagar = document.getElementsByClassName("selected");
  for (i = apagar.length - 1; i >= 0; i -= 1) {
    paiLista.removeChild(apagar[i]);
  }
}

//SALVANDO PAG
salvarTarefasBut.addEventListener("click", function () {
  window.localStorage.setItem("lista", paiLista.innerHTML);
});

paiLista.innerHTML = localStorage.getItem("lista");

//MOVER PRA CIMA
moverCimaBut.addEventListener("click", moveUp);

function moveUp() {
  let select = document.getElementsByClassName("selected")[0];
  let list = document.getElementsByTagName("li");
  let oldText = "";
  for (i = 0; i < list.length; i += 1) {
    if (list[i] === select && i != 0) {
      console.log(list[i]);
      console.log(select);
      oldText = list[i].innerHTML;
      list[i].innerHTML = list[i - 1].innerHTML;
      list[i - 1].innerHTML = oldText;
      list[i].classList.remove("selected");
      list[i].style.backgroundColor = "white";
      list[i - 1].style.backgroundColor = "rgb(128,128,128)";
      list[i - 1].classList.add("selected");
    } else {
      list[i].classList.remove("selected");
      list[i].style.backgroundColor = "white";
    }
  }
}
moverBaixoBut.addEventListener("click", moveDown);
function moveDown() {
  let select = document.getElementsByClassName("selected")[0];
  let list = document.getElementsByTagName("li");
  let oldText = "";
  for (i = list.length - 1; i >= 0; i -= 1) {
    if (list[i] === select && i != list.length - 1) {
      console.log(list[i]);
      console.log(select);
      oldText = list[i].innerHTML;
      list[i].innerHTML = list[i + 1].innerHTML;
      list[i + 1].innerHTML = oldText;
      list[i].classList.remove("selected");
      list[i].style.backgroundColor = "white";
      list[i + 1].style.backgroundColor = "rgb(128,128,128)";
      list[i + 1].classList.add("selected");
    } else {
      list[i].classList.remove("selected");
      list[i].style.backgroundColor = "white";
    }
  }
}
