function stringUtil(){
    let s = document.getElementById("str").value;
    
    let upp = s.toUpperCase();
    let low = s.toLowerCase();
    let v = ['a','e','i','o','u','A','E','I','O','U'];
    let vowels = [];
    let consonants = [];
    for(let i=0;i<s.length;i++){
        let c = s.charAt(i);
        if(v.includes(c)){
            vowels.push(c);
        }
        else{
            consonants.push(c);
        }
    }
    if(/\d/.test(s)){
        document.getElementById("num").innerHTML = "Enter only string without any number"+"<br>";
        console.log("Enter the string without any number");
    }
    else{
        
        document.getElementById("len").innerHTML = ""+s.length+"<br>";
        document.getElementById("uc").innerHTML = ""+upp+"<br>";
        document.getElementById("lc").innerHTML = ""+low+"<br>";
        document.getElementById("vow").innerHTML = ""+vowels+"<br>";
        document.getElementById("con").innerHTML = ""+consonants+"<br>";
    console.log(
        `Length of string: ${s.length}
         Uppercase : ${upp}
         Lowercase : ${low}
         Vowels : ${vowels}
         Consonants : ${consonants}
    `);
    }
}