function tryArray1() {
	// Initializing an array with literals
	var empty = [];
	var odds = [1, 3, 5, 7, 9];
	var mixed = [1, "Sujata", true];
	console.log("empty = " + empty);
	console.log("odds = " + odds);
	console.log("mixed = " + mixed);
}

function tryArray2() {
	// Initializing an array with a constructor
	var empty1 = new Array();
	var empty2 = new Array(10);
	var mixed = new Array(5, 4, 3, 2, 1, "testing,testing");;
	console.log("empty1 = " + empty1);
	console.log("empty2 = " + empty2);
	console.log("mixed = " + mixed);
}

function tryArray3() {
	var mixed = new Array();
	mixed[0] = 1;
	mixed[1] = "Sujata";
	mixed[2] = true;
	mixed.push(2);
	mixed.push(false);
	for (var i = 0; i < mixed.length; i++) {
		console.log(mixed[i]);
	}

	console.log("mixed = " + mixed);
	var popped = mixed.pop();
	console.log("popped = " + popped);
	console.log("mixed = " + mixed);

	// try shift and unshift

	// try enhanced for

	// indexoutofbounds exception?
}

function findSquares() {
	var nums = [1, 2, 3, 4];
	var squares = [];

	for(let i of nums) {
		squares.push(i ** 2);
	}

	// this works too
	var mapsquares = nums.map(squareIt);

	// this works, but won't put values in the array
	//var fEsquares = nums.forEach(squareIt);

	// this gives square of index! not square of number at index!
	//for (n in nums) {
	//	console.log(n);
	//}
	
	console.log("squares " + squares);
	console.log("squares using map " + mapsquares);
	//console.log("squares using forEach " + fEsquares);
}

function squareIt(n) {
	console.log(n ** 2);
	return n ** 2;
}