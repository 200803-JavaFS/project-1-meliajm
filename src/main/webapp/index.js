let url = 'http://localhost:8080/project1/';

document.getElementById("loginbtn").addEventListener("click", loginFunc);

async function loginFunc() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    console.log(username);
    let user = {
        username : username,
        password : password
    }

    let resp = await fetch(url+"login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials : "include"
    })

    if(resp.status===200){
        console.log(resp);
        console.log(user);

        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN "+user.username;
        // let button = document.createElement('button');
        // button.className = "btn btn-success";
        // button.id = "findAllBtn";
        // button.innerText = "Show All My Reimbursements";
        // button.onclick=findAllFunc;
        // document.getElementById("table-row").appendChild(button);
        createButtonWithid("findAllBtn", "Show All My Reimbursements", findAllFunc);
        createButtonWithid("addReimbBtn", "Submit New Request", addReimbContent);

    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function findAllFunc() {
    const myHeaders = new Headers();
    myHeaders.append("Origin", "corssucklol");
    let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });

    if(resp.status===200){
        let data = await resp.json;
        console.log(data);
    }
    // loop through reimbs and append to table
}

async function addReimbContent() {
    console.log("add reimb");
    // post reimb to db
    const myHeaders = new Headers();
    myHeaders.append("Origin", "corssucklol");
    let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });

    if(resp.status===200){
        let data = await resp.json;
        console.log(data);
    }
}

function createButtonWithid(id, buttonText, func) {
    let button = document.createElement('button');
        button.className = "btn btn-success";
        // button.id = "findAllBtn";
        button.id = id;
        button.innerText = buttonText;
        // button.onclick=findAllFunc;
        button.onclick=func;
        document.getElementById("table-row").appendChild(button);
}

