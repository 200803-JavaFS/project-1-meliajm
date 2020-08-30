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
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN "+user.username;
        createButtonWithid("findAllBtn", "Show All My Reimbursements", findAllFunc);
        createButtonWithid("addReimbBtn", "Submit New Request", showAddReimbForm);
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
    addReimbContent();
    // loop through reimbs and append to table
}

function addReimbContent() {
    console.log("add reimb");
    // // post reimb to db
    // const myHeaders = new Headers();
    // myHeaders.append("Origin", "corssucklol");
    // let resp = await fetch(url+"add", {
    //     credentials: 'include',
    //     headers: {
    //         Origin: "corssucks"
    //     }
    //   });

    // if(resp.status===200){
    //     let data = await resp.json;
    //     console.log(data);
    // }
}

function createButtonWithid(id, buttonText, func) {
    // put buttons on two diff elements
    let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = id;
        button.innerText = buttonText;
        button.onclick=func;
        document.getElementById("table-row").appendChild(button);
}

function showAddReimbForm() {
    let row = document.getElementById("to-add-reimb");
    let div = document.createElement('div');
    let addReimbBtn = document.getElementById('addReimbBtn');
    addReimbBtn.style.display = 'none';
    let br = document.createElement('br');
    div.className = 'row';
    div.id = 'add-reimb-row';
    let input1 = document.createElement('input');
    input1.className = 'col-sm-4 form-control';
    input1.name = 'amount';
    input1.placeholder = 'amount';
    input1.type = 'text';
    row.appendChild(div);
    row.appendChild(br);
    div.insertAdjacentElement('afterend', input1);

    let input2 = document.createElement('input');
    input2.className = 'col-sm-4 form-control';
    input2.name = 'time-submitted';
    input2.placeholder = 'time submitted';
    input2.type = 'text';
    input1.insertAdjacentElement('afterend', input2);

    let input3 = document.createElement('input');
    input3.className = 'col-sm-4 form-control';
    input3.name = 'time-resolved';
    input3.placeholder = 'time-resolved';
    input3.type = 'text';
    input2.insertAdjacentElement('afterend', input3);

    let input4 = document.createElement('input');
    input4.className = 'col-sm-4 form-control';
    input4.name = 'descr';
    input4.placeholder = 'descr';
    input4.type = 'text';
    input3.insertAdjacentElement('afterend', input4);

    // let input5 = document.createElement('input');
    // input5.className = 'col-sm-4 form-control';
    // input5.name = 'descr';
    // input5.placeholder = 'descr';
    // input5.type = 'text';
    // input4.insertAdjacentElement('afterend', input5);

    let input5 = document.createElement('input');
    input5.className = 'col-sm-4 form-control';
    input5.name = 'author';
    input5.placeholder = 'author';
    input5.type = 'text';
    input4.insertAdjacentElement('afterend', input5);

    let input6 = document.createElement('input');
    input6.className = 'col-sm-4 form-control';
    input6.name = 'resolver';
    input6.placeholder = 'resolver';
    input6.type = 'text';
    input5.insertAdjacentElement('afterend', input6);

    let input7 = document.createElement('input');
    input7.className = 'col-sm-4 form-control';
    input7.name = 'status';
    input7.placeholder = 'status';
    input7.type = 'text';
    input6.insertAdjacentElement('afterend', input7);

    let input8 = document.createElement('input');
    input8.className = 'col-sm-4 form-control';
    input8.name = 'type';
    input8.placeholder = 'type';
    input8.type = 'text';
    input7.insertAdjacentElement('afterend', input8);

    let butn = document.createElement('button');
    butn.className = 'btn btn-success';
    butn.id = 'submit-reimb';
    butn.innerText = 'Submit your request';
    butn.onclick = submitReimb;
    input8.insertAdjacentElement('afterend', butn);

    // return `
    // <div class="row" id="add-reimb-row">
    //     <h3 class="col-lg-12">Please Submit your new request:</h3>
    //     <input class="col-sm-4 form-control" id="amount" type="text" name="amount" placeholder="amount">
    //     <input class="col-sm-4 form-control" id="time-submitted" type="text" placeholder="time submitted" name="time-submitted">
    //     <input class="col-sm-4 form-control" id="time-resolved" type="text" placeholder="time resolved" name="time-resolved">
    //     <input class="col-sm-4 form-control" id="descr" type="text" placeholder="description" name="descr">
    //     <input class="col-sm-4 form-control" id="author" type="text" placeholder="author" name="author">
    //     <input class="col-sm-4 form-control" id="resolver" type="text" placeholder="resolver" name="resolver">
    //     <input class="col-sm-4 form-control" id="status" type="text" placeholder="status" name="status" value="Pending">
    //     <input class="col-sm-4 form-control" id="type" type="text" placeholder="type" name="type" value="Other">        
    //     <button id="loginbtn" class="btn btn-success">Login</button>
    // </div>
    // `
}

async function submitReimb() {
    console.log('submitting your request')
    let amount = document.getElementById("amount").value;
    let timeSubmitted = document.getElementById("time-submitted").value;
    let timeResolved = document.getElementById("time-resolved").value;
    let descr = document.getElementById("descr").value;
    let author = document.getElementById("author").value;
    let resolver = document.getElementById("resolver").value;
    let status = document.getElementById("status").value;
    let type = document.getElementById("type").value;

    // console.log(username);
    let reimb = {
        amount : amount,
        timeSubmitted : timeSubmitted,
        timeResolved : timeResolved,
        descr : descr,
        author : author,
        resolver : resolver,
        status : status,
        type : type 
    }

    let resp = await fetch(url+"add", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials : "include"
    })

    if(resp.status===200){
        document.getElementById("login-row").innerText = "Your request has been successfully submitted "+user.username;
    } else {
        document.getElementById("login-row").innerText = "Your request has NOT been successfully submitted";
    }
}



