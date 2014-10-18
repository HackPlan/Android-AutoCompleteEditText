# AutoCompleteEditText

A simple EditText that can show a drop-down list after input '#' symbol.

![AutoCompleteEditText](https://raw.githubusercontent.com/HackPlan/Android-AutoCompleteEditText/master/preview.gif)

It was used in [Pomotodo](https://play.google.com/store/apps/details?id=com.pomotodo)

## Usage

```xml
<im.dacer.AutoCompleteEditText
    android:id="@+id/edit_text"
    android:layout_height="wrap_content"
    android:layout_width="fill_parent"/>
```

```java
AutoCompleteEditText editText = (AutoCompleteEditText) findViewById(R.id.edit_text);
editText.setStartAtSymbol("#");
editText.setAutoCompleteList(list);
```

## License

The MIT License (MIT)

Copyright (c) 2014 Ding Wenhao

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/github/android/pulls).

Any contributions, large or small, major features, bug fixes, additional
language translations, unit/integration tests are welcomed