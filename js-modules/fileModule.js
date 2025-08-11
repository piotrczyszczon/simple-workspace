
export const addFileModuleElement = (parentElement) => {
  const newDiv = document.createElement("div");
  const newContent = document.createTextNode("Text inside fileModule.js");
  newDiv.appendChild(newContent);

  document.body.insertBefore(newDiv, parentElement);
}

export const logFileModule = () => {
  console.log("File Module alive!")
}