 function pwIsSame() {
     var pw = document.twin.pw.value;
     var pwCheck = document.twin.pwCheck.value;

      if (pw.length < 6 || pw.length > 16) {
             window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
             document.getElementById('pw').value=document.getElementById('pwCheck').value='';
             document.getElementById('same').innerHTML='';
         }
         if(document.getElementById('pw').value!='' && document.getElementById('pwCheck').value!='') {
             if(document.getElementById('pw').value==document.getElementById('pwCheck').value) {
                 document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
                 document.getElementById('same').style.color='blue';
             }
             else {
                 alert('비밀번호가 일치하지 않습니다.')
                 document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
                 document.getElementById('same').style.color='red';
             }
         }
     }



