// SETA A COR SELECIONADA INICIAL COMO PRETO
window.onload = function () {
  let selectedClass = document.getElementsByClassName("firstColor")[0];
  selectedClass.classList.add("selected");
  selectedClass.style.backgroundColor = "black";
  let randonColor1 = document.getElementsByClassName("default1")[0];
  randonColor1.style.backgroundColor = geraCor();
  let randonColor2 = document.getElementsByClassName("default2")[0];
  randonColor2.style.backgroundColor = geraCor();
  let randonColor3 = document.getElementsByClassName("default3")[0];
  randonColor3.style.backgroundColor = geraCor();
};

//GERA CORES ALEATORIAS
function geraCor() {
  let hexadecimais = "0123456789ABCDEF";
  let cor = "#";

  for (i = 0; i < 6; i++) {
    cor += hexadecimais[Math.floor(Math.random() * 16)];
  }
  return cor;
}

//GERA LINHAS DO GRID
function lineGenerate(lineNumbers) {
  for (i = 0; i < lineNumbers; i += 1) {
    let lineCreate = document.createElement("div");
    lineCreate.className = "line" + i + " " + "remove";

    let fatherDiv = document.getElementById("pixel-board");
    fatherDiv.appendChild(lineCreate);
  }
}

//GERA PIXELS DO GRID
function pixelGenerate(pixelNumbers) {
  let pixelCreate;
  let pixelFather;
  for (i = 0; i < pixelNumbers; i += 1) {
    if (i <= 4) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";

      pixelFather = document.getElementsByClassName("line0")[0];
      pixelFather.appendChild(pixelCreate);
    }
    if (i <= 9 && i > 4) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";

      pixelFather = document.getElementsByClassName("line1")[0];
      pixelFather.appendChild(pixelCreate);
    }
    if (i <= 14 && i > 9) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";

      pixelFather = document.getElementsByClassName("line2")[0];
      pixelFather.appendChild(pixelCreate);
    }
    if (i <= 19 && i > 14) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";

      pixelFather = document.getElementsByClassName("line3")[0];
      pixelFather.appendChild(pixelCreate);
    }
    if (i <= 24 && i > 19) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";

      pixelFather = document.getElementsByClassName("line4")[0];
      pixelFather.appendChild(pixelCreate);
    }
  }
}
lineGenerate(5);
pixelGenerate(25);

//GERA GRID DE ACORDO COM USUARIO
let quadro = document.getElementById("board-size");
let formar = document.getElementById("generate-board");
formar.addEventListener("click", function () {
  let removalChild = document.getElementsByClassName("remove");

  for (i = removalChild.length - 1; i >= 0; i--) {
    let removalFather = document.getElementById("pixel-board");
    removalFather.removeChild(removalChild[i]);
  }

  //CORRIGINFO VALORES DE LINHA E PIXEL
  if (quadro.value == "") {
    alert("Board inválido!");
  }
  linha = parseInt(quadro.value);
  if (linha < 5) {
    linha = 5;
  }
  if (linha > 50) {
    linha = 50;
  }

  //GERANDO LINHAS
  lineGenerate(linha);

  //REMOVENDO GRID PADRAO E CORRIGINDO WIDTH E HEIGHT
  let removalFather = document.getElementById("pixel-board");
  let newWidth = linha * 42;
  removalFather.style.width = newWidth + "px";
  removalFather.style.height = newWidth + "px";

  //CRIANDO PIXELS NOVOS
  for (i = 0; i < linha; i += 1) {
    for (k = 0; k < linha; k += 1) {
      pixelCreate = document.createElement("div");
      pixelCreate.className = "pixel blank";
      let classActualName = "line" + i;
      pixelFather = document.getElementsByClassName(classActualName)[0];
      pixelFather.appendChild(pixelCreate);
    }
  }
});
//INPUT VALUE CORRECTION
function checkValue(object) {
  if (object.value <= 0) {
    alert("Board inválido!");
  }
}

//TROCA A SELEÇÃO DA PALETA DE CORES
function selection(event) {
  let oldSelection = document.getElementsByClassName("selected")[0];
  oldSelection.classList.remove("selected");

  let target = event.target;
  target.classList.add("selected");
}
let black = document.getElementsByClassName("firstColor")[0];
black.addEventListener("click", selection);
let color1 = document.getElementsByClassName("default1")[0];
color1.addEventListener("click", selection);
let color2 = document.getElementsByClassName("default2")[0];
color2.addEventListener("click", selection);
let color3 = document.getElementsByClassName("default3")[0];
color3.addEventListener("click", selection);

//TROCA A COR DO PIXEL
let pixTable = document.getElementById("pixel-board");
pixTable.addEventListener("click", changeColor);
function changeColor(event) {
  let selectedPallete = document.getElementsByClassName("selected")[0];
  let selectedPixel = event.target;
  let novaCor = selectedPallete.style.backgroundColor;
  selectedPixel.classList.remove(selectedPixel.classList[1]);
  selectedPixel.style.backgroundColor = novaCor;
}

//BLANK EVERYTHING
function blankColor() {
  let blanker = document.getElementsByClassName("pixel");
  for (i = 0; i < blanker.length; i += 1) {
    blanker[i].style.backgroundColor = "white";
  }
}
let blankerBut = document.getElementById("clear-board");
blankerBut.addEventListener("click", blankColor);
