<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring React</title>
<script>
  function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
  }
</script>
</head>
<body>
<iframe src="http://localhost:8087/home" style="width: 100%; border: 0" onload="resizeIframe(this)"></iframe>

</body>
</html>