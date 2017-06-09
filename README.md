# Osakeuutisbotti

This bot gathers Finnish stock news and posts them to twitter.

Currently this bot uses only one feed: Finnish GlobeNewswire

Botti, joka kokoaa suomalaisten osakeuutisten virtoja ja twiittailee niitä.

[Twitter](https://www.twitter.com/osakeuutiset)


## Usage

### Environment variables

### Twitter

    APP_CONSUMER_KEY
    APP_CONSUMER_SECRET
    USER_ACCESS_TOKEN
    USER_ACCESS_TOKEN_SECRET

#### GlobalNewswire

    GW_URL

### Building and running

    $ lein uberjar    
    $ java -jar target/stock-twitter-bot-0.1.0-standalone.jar

## TODO

- Check http codes of parser and twitter
- Maybe Slack integration
- Maybe intelligent $STOCK parser

## License

Copyright © 2017 Matti Ahinko

Distributed under the MIT License.
