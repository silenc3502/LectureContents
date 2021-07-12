<script type="text/javascript">
// 공백이 있나 없나 체크
function checkSpace(str) {
	if(str.search(/\s/) != -1) {
		return true;
	} else {
		return false;
	}
}

// 특수 문자가 있나 없나 체크
function checkSpecial(str) {
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

	if(special_pattern.test(str) == true) {
		return true;
	} else {
		return false;
	}
}
</script>