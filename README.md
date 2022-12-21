# JSON-tools
An app for developers who need to reformat or filter data structures saved in JSON format and compare structures with each other. JSON-tools allows you to minify an unminified JSON representation as well as the reverse operation (adding any spaces and newlines). The application will be available through a GUI as well as a remote API.

## Documentation
The code-level documentation is available at https://kxpi.github.io/JSON-tools/javadoc/. Moreover, an UML diagram can be found [in the repository root](https://github.com/Kxpi/JSON-tools/blob/main/JsonTools%20UML.png).

## Usage
The application listens at port `8080`. It exposes single endpoint, namely `/json`, that accepts two parameters (`action` and `format`) and expects the JSON string to be passed as the request body.

`format` can be one of following: `minified`, `pretty`. These values are pretty self-explanatory and do exactly what one can expect.

`action` is a string built as follows: `action1:param1,param2,param3;action2:param1`. It can consist of numerous action designators separated with semicolon (`;`). Furthermore, each designator has to specify the action name followed by optional parameters list. Parameters are separated with commas (`,`). The parameter list can be totally ommited, in which case the colon (`:`) after the action name is not necessary.

At the moment there are two actions implemented `remove` and `keep`. They both aim to filter the properties present in the top-level object. `remove` accepts a list of keys that are to be deleted from the object (keeping everything else) whereas `keep` keeps only the specified keys and removes the rest.

## Example request
```http
GET /json?action=keep:a,b&format=pretty HTTP/1.1
Content-Type: application/json
Content-Length: 33

{"a":1,"b":"xyz","c":[],"d":null}

```
It will return an output like the following:
```json
{
  "a": 1,
  "b": "xyz"
}
```
