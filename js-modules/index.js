import { addFileModuleElement } from "./fileModule.js";

// this import does not work in browser, but the approach is valid for node
// import { addDirectoryModuleElement } from "directory-module/directoryModule";

document.body.onload = addElement;

function addElement() {
  const newDiv = document.createElement("div");
  const newContent = document.createTextNode("Text inside index.js");
  newDiv.appendChild(newContent);

  const currentDiv = document.getElementById("root");
  document.body.insertBefore(newDiv, currentDiv);

  addFileModuleElement(newDiv)
  // addDirectoryModuleElement(newDiv)
}