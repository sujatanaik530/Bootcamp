function functionEven() {
	var outText = "Even numbers between 0 and 100: ";
	for (var i = 0; i < 100; i++) {
		if (i % 2 == 0) {
			outText += i + " ";
		}
	}
	document.getElementById('output').innerHTML = outText;
}

function functionOdd() {
	var outText = "Odd numbers between 0 and 100: ";
	for (var i = 0; i < 100; i++) {
		if (i % 2 == 1) {
			outText += i + " ";
		}
	}
	document.getElementById('output').innerHTML = outText;
}

function functionPrimeOrNot() {
	var num = prompt("Enter a number");
	var notprime = false;
	var outText = num + " is ";
	if (num == 1) {
		notprime = true;
	}
	else {
		for (var i = 2; i < num; i++) {
			if ((num % i) == 0) {
				notprime = true;
				break;
			}
		}
	}
	if (notprime) {
		outText += "not a prime number.";
	}
	else {
		outText += "a prime number.";
	}
	document.getElementById('output').innerHTML = outText;
}

function functionDivisibleBy4And6() {
	var outText = "Numbers between 10 and 1000 that are divisible by 4 and 6: ";
	for (var i = 0; i < 100; i++) {
		if ((i % 4 == 0) && (i % 6 == 0)) {
			outText += i + " ";
		}
	}
	document.getElementById('output').innerHTML = outText;
}
