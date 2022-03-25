function myFunction() {
	var RATE = 5;
	var INITIAL_BALANCE = 10000;
	var TARGET_BALANCE = 2 * INITIAL_BALANCE;
	var balance = INITIAL_BALANCE;
	var year = 0;
	while (balance < TARGET_BALANCE) {
		var interest = balance * RATE / 100;
		balance += interest;
		year++;
	}
	outText = "The investment doubled in " + year + " years.";
	document.getElementById("numyears").innerHTML = outText;
}