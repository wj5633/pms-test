function FindProxyForURL(url, host) {
    console.log(url)
    console.log(host)

    return "PROXY 10.0.1.1:8080";
}
