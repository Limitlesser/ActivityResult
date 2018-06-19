# ActivityResult
    更方便的处理页面返回的结果
    
以往我们调用相机拍照或跳到别的页面获取一些数据时往往是这样的

```Java
   val intent = Intent(this, Main2Activity::class.java)
   startActivityForResult(intent)
```

然后在onActivityResult里处理结果

```Java
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            Toast.makeText(this, "收到结果:${data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                    .show()
    }
```

这样的代码失去了连贯性 阅读起来也很困难

使用ActivityResult的代码看起来是这样的

```Java
 val intent = Intent(this, Main2Activity::class.java)
    startActivityForResult(intent)
               .subscribe {
                   if (it.isOk)
                       Toast.makeText(this, "收到结果:${it.data?.getStringExtra("data")}", Toast.LENGTH_SHORT)
                               .show()
               }
```
逻辑上非常连贯