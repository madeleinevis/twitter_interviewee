const Tweets = (tweetList) => {
    let tweets = tweetList.items;

    if(tweets === {}) {
        return <p>No Tweets made by the user.</p>
    }else {
        // Object.entries(tweets).map(([key, value]) => console.log(key, value[0], value[1]));
        // Object.entries(tweets).map(([key, [tID, tweet, timestamp]]) => console.log([tID, tweet, timestamp]));
        tweets.map(({timestamp, tweet, tweetID}) => console.log({timestamp, tweet, tweetID}));
        return (<table>
            <thead>
                <tr>
                    <th>TweetID</th>
                    <th>Tweet</th>
                    <th>Timestamp</th>
                </tr>
            </thead>
            <tbody>
            {tweets.map(({timestamp, tweet, tweetID}) => {
                return (<tr>
                    <td>{tweetID}</td>
                    <td>{tweet}</td>
                    <td>{timestamp}</td>
                </tr>);
            })}
            </tbody>
        </table>);
    }
}
export default Tweets;