import { logFileModule } from "./fileModule.js";
import { logDirectoryModule } from "directory-module/directoryModule";


function logMainScript() {
  console.log("Main Script alive!")
}

logMainScript()
logFileModule()
logDirectoryModule()