function customMsg(msg, times) {
	for (var i = 0; i < times; i++) {
		//console.log(i, msg);
		document.getElementById("tag").innerHTML += msg;
	}
}

const err = new Error("Custom Error");
console.log(err);

function printprops(p) {
	for (var o in p) {
		//debugger;
		console.log(o + ": " + p[o] + "\n");
	}
}
var p = {
	first_name: "Luke",
	last_name: "Lance",
	age: 23
}
printprops(p);