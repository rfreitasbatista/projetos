//TEXT INPUT
let textInput = document.getElementById("text-input");
let textOutput = document.getElementById("meme-text");
textInput.addEventListener("keyup", memeTextAdd);

function memeTextAdd() {
  textOutput.innerHTML = textInput.value;
}

//IMAGE INPUT
let memeInput = document.getElementById("meme-insert");
let memeImage = document.getElementById("meme-image");
memeInput.addEventListener("change", function () {
  readURL(this);
});
function readURL(input) {
  if (input.files && input.files[0]) {
    let reader = new FileReader();
    reader.onload = function (event) {
      memeImage.setAttribute("src", event.target.result);
    };
    reader.readAsDataURL(input.files[0]);
  }
}

//BORDER CHANGE BUTTONS
let bdrChange = document.getElementById("meme-image-container");
let fireBut = document.getElementById("fire");
fireBut.addEventListener("click", function () {
  bdrChange.style.border = "3px dashed red";
  console.log(bdrChange.style.border);
});

let waterBut = document.getElementById("water");
waterBut.addEventListener("click", function () {
  bdrChange.style.border = "5px double blue";
  console.log(bdrChange.style.border);
});

let earthBut = document.getElementById("earth");
earthBut.addEventListener("click", function () {
  bdrChange.style.border = "6px groove green";
  console.log(bdrChange.style.border);
});

//MEME DEFAULT
function selection(event) {
  let target = event.target;
  console.log(target.src);
  let mainImg = document.getElementById("meme-image");
  mainImg.src = target.src;
}

let meme01 = document.getElementById("meme-1");
meme01.addEventListener("click", selection);
let meme02 = document.getElementById("meme-2");
meme02.addEventListener("click", selection);
let meme03 = document.getElementById("meme-3");
meme03.addEventListener("click", selection);
let meme04 = document.getElementById("meme-4");
meme04.addEventListener("click", selection);
