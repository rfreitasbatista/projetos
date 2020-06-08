const estilo = ["newspaper", "magazine1", "magazine2"];
const tamanho = ["medium", "big", "reallybig"];
const rotacao = ["rotateleft", "rotateright"];
const skew = ["skewleft", "skewright"];
const fatherText = document.getElementById("carta-gerada");
const inputText = document.getElementById("carta-texto");
const inputBut = document.getElementById("criar-carta");
const contadorP = document.getElementById('carta-contador');

function geraRandom(n) {
  const random = Math.floor(Math.random() * n);
  return random;
}

function geraEstilo() {
  let estilogerado = estilo[geraRandom(3)];
  let tamanhogerado = tamanho[geraRandom(3)];
  let rotacaogerado = rotacao[geraRandom(2)];
  let skewgerado = skew[geraRandom(2)];
  let novoGrupoDeClass =
    estilogerado + " " + tamanhogerado + " " + rotacaogerado + " " + skewgerado;
  return novoGrupoDeClass;
}

function geraSpan(n) {
  let novoSpan = document.createElement("span");
  novoSpan.className = geraEstilo();
  novoSpan.innerHTML = n;

  fatherText.appendChild(novoSpan);
}

function removeOldSpan() {
  let oldSpan = document.getElementsByTagName("span");
  for (let i = oldSpan.length - 1; i >= 0; i--) {
    fatherText.removeChild(oldSpan[i]);
  }
}

function splitter() {
  removeOldSpan();
  const texto = inputText.value;
  const textoSplit = texto.split(" ");
  let counter = 0
  for (let i = 0; i < textoSplit.length; i++) {
    geraSpan(textoSplit[i]);
    counter += 1
  }
  contadorP.innerText = counter
}

function mudarAoClick(event) {
  const target = event.target;
  target.className = geraEstilo();
}

inputBut.addEventListener("click", splitter);
fatherText.addEventListener("click", mudarAoClick);


