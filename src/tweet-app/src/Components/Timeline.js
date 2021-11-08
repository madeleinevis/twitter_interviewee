const Timeline = (tweetList) => {
    let tweets = tweetList.items;
    if(tweets === {}) {
        return <p>No Tweets to Display.</p>
    }else{
        tweets.map(({timestamp, tweet, tweetID, username}) => console.log({timestamp, tweet, tweetID, username}));
        return (<table>
            <thead>
            <tr>
                <th>TweetID</th>
                <th>Tweet</th>
                <th>Timestamp</th>
                <th>Username</th>
            </tr>
            </thead>
            <tbody>
            {tweets.map(({timestamp, tweet, tweetID, username}) => {
                return (<tr>
                    <td>{tweetID}</td>
                    <td>{tweet}</td>
                    <td>{timestamp}</td>
                    <td>{username}</td>
                </tr>);
            })}
            </tbody>
        </table>);
    }
}
export default Timeline;