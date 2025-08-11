# Idea
The purpose of this simple project is to demonstrate the way browser and node handle modules. Browser can load dependent file fileModule.js and execute its content but it does not support package.json structures so it cannot load directory module. Node can do both, it can execute imported file, but also it can run code from directory-module. Note that the file has to be specified under exports: {} section of the modules package.json file.

## Browser
### To run in the browser with CORS errors, the file serving server is needed.
npx serve .

## Node
### To Run node script simply execute command
node clit-tool.js

## Observations
- The browser will not be able to load modules if you remove type="module" attribute from the `<script>` tag inside index.html. It will show error: SyntaxError: Cannot use import statement outside a module
- The node will complain the script is not module if you remove type="module" from package.json. But it will only show warning and assume it indeed is a module and load it correctly :).
- Browser load modules asynchronously. looking at dev tools, it can be seenfileModule is loaded after index.js and then the page is painted. 