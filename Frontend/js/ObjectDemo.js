function fun() {
	var student = {
		firstname: "Sujata",
		lastname: "Naik",
		age: 25,
		class: "Java Developer"
	}
	student.score = "90%";

	function Student(fn, ln, a, cl) {
		this.firstname = fn;
		this.lastname = ln;
		this.age = a;
		this.class = cl;
	}
	var s1 = new Student("John", "Doe", 30, "Python Developer");
	s1.age = 35;

	console.log("Constructor" + s1.age);

	var p = document.getElementById('output');
	p.innerHTML = student.score;
	console.log(student.class);
	console.log(student);

	for (var x in student) {
		console.log(student[x]);
	}
}