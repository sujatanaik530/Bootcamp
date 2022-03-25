function printBox() {
	var w = prompt("What is the width?");
	var h = prompt("What is the height?");
	var outText = "";
	for (var i = 0; i < h; i++) {
		for (var j = 0; j < w; j++) {
			outText += "*";
		}
		outText += "<br>";
	}
	document.getElementById('boxPrint').innerHTML = outText;
}

function printCheckerboard() {
	var w = prompt("What is the width?");
	var h = prompt("What is the height?");
	var outText = "";
	var rowstart = "X";
	var curr = rowstart;
	for (var i = 0; i < h; i++) {
		for (var j = 0; j < w; j++) {

			outText += curr;
			if (curr == "0") {
				curr = "X";
			}
			else {
				curr = "0";
			}
		}
		outText += "<br>";
		debugger;
		if (rowstart == "X") {
			rowstart = "0";
			curr = rowstart;
		}
		else {
			rowstart = "X";
			curr = rowstart;
		}
	}
	document.getElementById('checkerboardPrint').innerHTML = outText;	
}

function printCross() {
	var l = prompt("What is the length?");
	var outText = "";
	for (var i = 0; i < l; i++) {
		for (var j = 0; j < l; j++) {
			if (i == j) {
				outText += "*";	
			}
			else if (i + j == l - 1) {
				outText += "*";
			}
			else {
				outText += "&nbsp";
			}
		}
		outText += "<br>";
	}
	document.getElementById('crossPrint').innerHTML = outText;
}

function printLBTriangle() {
	var l = prompt("What is the length of the side?");
	var outText = "";
	for (var i = 0; i < l; i++) {
		for (var j = 0; j <= i; j++) {
			outText += "*";
		}
		outText += "<br>";
	}
	document.getElementById('lbTriangle').innerHTML = outText;	
}

function printRTTriangle() {
	var l = prompt("What is the length of the side?");
	var outText = "";
	for (var i = 0; i < l; i++) {
		for (var j = 0; j < l; j++) {
			//debugger;
			if (j < i) {
				outText += "0";
			}
			else {
				outText += "8";
			}
		}
		outText += "<br>";
	}
	document.getElementById('rtTriangle').innerHTML = outText;	
}

function printTrapezoid() {
	var w = prompt("What is the width of the trapezoid?");
	var h = prompt("What is the height of the trapezoid?");
	var outText = "";
	if (w - (h - 1) * 2 <= 0) {
		alert("Impossible trapezoid!");
		document.getElementById('trapPrint').innerHTML = outText;
	}
	else {
		for (var i = 0; i < h; i++) {
			for (var j = 0; j < w - i; j++) {
				if (j < i) {
					outText += "&nbsp";
				}
				else {
					outText += "*";
				}
			}
			outText += "<br>";
		}
		document.getElementById('trapPrint').innerHTML = outText;
	}
}