let url = 'http://localhost:8080/project1/';

document.getElementById('financeM').style.display='none';
document.getElementById('employee').style.display='none';

document.getElementById("loginbtn").addEventListener("click", loginFunc);
document.getElementById('filterStatusBtn').addEventListener("click", queryReimb);
document.getElementById('SelectBtn').addEventListener("click", selectReimb);
document.getElementById('UpdateBtn').addEventListener("click", updateReimb);

async function updateReimb() {
    stat = document.getElementById('updateReimb').value;
    if (document.getElementById('link').innerHTML===document.getElementById('reimbID').value
    ) {
        console.log('updating reimb to '+ stat);
        // do post here
    }
}
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
        if (user.username==='captain' || user.username==='liz') {
            findAllFunc(user.username);
            document.getElementById('financeM').style.display='block';
        } else {
            findAllFunc(user.username);
            document.getElementById('employee').style.display='block';
        }

    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function selectReimb() {

    let reimbID = document.getElementById("reimbID").value;
    console.log("you've picked this reimb id "+ reimbID);
    // document.getElementById('select').innerHTML = '';

    let response = await fetch(url+"reimbursement/"+reimbID+'/');

    if(response.status === 200) {
        let data = await response.json();
        console.log(data);
        let tbody = document.getElementById('reimb-body');
        tbody.innerHTML= "";
        let newRow = document.createElement('tr');
        let td1 = document.createElement('td');
        td1.id = "link"
        td1.innerText = data.reimbID; 
        td1.style.color = 'blue';
        
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        let td5 = document.createElement('td');
        let td6 = document.createElement('td');
        let td7 = document.createElement('td');

        td2.innerText = data.reimbAmount;
        if (data.timeSubmitted===null) {
            td3.innerText = "not updated"
        } else {
            td3.innerText = data.timeSubmitted.hour+"."+data.timeSubmitted.minute+"."+data.timeSubmitted.second;
        }
        if (data.timeResolved===null) {
            td4.innerText = "not updated"
        } else {
            td4.innerText = data.timeResolved.hour+"."+data.timeResolved.minute+"."+data.timeResolved.second;
        }
        td5.innerText = data.reimbDescription;
        td6.innerText = data.reimbType.reimbType
        td7.innerText = data.reimbStatus.reimbStatus;

        newRow.appendChild(td1);
        newRow.appendChild(td2);
        newRow.appendChild(td3);
        newRow.appendChild(td4);
        newRow.appendChild(td5);
        newRow.appendChild(td6);
        newRow.appendChild(td7);

        tbody.appendChild(newRow);
    } else {
        console.log('that did not work');
    }
    // reimbID = document.getElementById("reimbID").value='';
}

async function queryReimb() {
    let query = document.getElementById("filterID").value;
    console.log(query);
    // document.getElementById('select').innerHTML = '';

    const myHeaders = new Headers();
    myHeaders.append("Origin", "corssucklol");
    let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });

    if(resp.status===200){
        let data = await resp.json();
        let tbody = document.getElementById('reimb-body');
        tbody.innerHTML= "";
        for (let i = 0; i < data.length; i++) {
            if (query===data[i].reimbStatus.reimbStatus) {
                console.log(data);

                let tbody = document.getElementById('reimb-body');
                console.log(data[i]);
                console.log("amount: "+data[i].reimbAmount);
                let newRow = document.createElement('tr');
                let td1 = document.createElement('td');
                td1.id = "link" 
                td1.innerText = data[i].reimbID; 
                td1.style.color = 'blue';
            
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');
                let td6 = document.createElement('td');
                let td7 = document.createElement('td');

                td2.innerText = data[i].reimbAmount;
                if (data[i].timeSubmitted===null) {
                    td3.innerText = "not updated"
                } else {
                    td3.innerText = data[i].timeSubmitted.hour+"."+data[i].timeSubmitted.minute+"."+data[i].timeSubmitted.second;
                }
                if (data[i].timeResolved===null) {
                    td4.innerText = "not updated"
                } else {
                    td4.innerText = data[i].timeResolved.hour+"."+data[i].timeResolved.minute+"."+data[i].timeResolved.second;
                }
                td5.innerText = data[i].reimbDescription;
                td6.innerText = data[i].reimbType.reimbType
                td7.innerText = data[i].reimbStatus.reimbStatus;

                newRow.appendChild(td1);
                newRow.appendChild(td2);
                newRow.appendChild(td3);
                newRow.appendChild(td4);
                newRow.appendChild(td5);
                newRow.appendChild(td6);
                newRow.appendChild(td7);

                tbody.appendChild(newRow);
                }
          }
    }
    query = document.getElementById("filterID").value='';


}

async function findAllFunc(username) {
    // if (username==='captain' || username==='liz') {
        const myHeaders = new Headers();
        myHeaders.append("Origin", "corssucklol");
        let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });
        if(resp.status===200){
            let data = await resp.json();
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                let tbody = document.getElementById('reimb-body');
                console.log(data[i]);
                console.log("amount: "+data[i].reimbAmount);
                let newRow = document.createElement('tr');
                let td1 = document.createElement('td');
                td1.id = "link" 
                td1.innerText = data[i].reimbID; 
                td1.style.color = 'blue';
            
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');
                let td6 = document.createElement('td');
                let td7 = document.createElement('td');

                td2.innerText = data[i].reimbAmount;
                if (data[i].timeSubmitted===null) {
                    td3.innerText = "not updated"
                } else {
                    td3.innerText = data[i].timeSubmitted.hour+"."+data[i].timeSubmitted.minute+"."+data[i].timeSubmitted.second;
                }
                if (data[i].timeResolved===null) {
                    td4.innerText = "not updated"
                } else {
                    td4.innerText = data[i].timeResolved.hour+"."+data[i].timeResolved.minute+"."+data[i].timeResolved.second;
                }
                td5.innerText = data[i].reimbDescription;
                td6.innerText = data[i].reimbType.reimbType
                td7.innerText = data[i].reimbStatus.reimbStatus;

                newRow.appendChild(td1);
                newRow.appendChild(td2);
                newRow.appendChild(td3);
                newRow.appendChild(td4);
                newRow.appendChild(td5);
                newRow.appendChild(td6);
                newRow.appendChild(td7);

                tbody.appendChild(newRow);
            }
        // } else {
        //     console.log('user is employee, can only see her reimbs')
        // }
    }
}