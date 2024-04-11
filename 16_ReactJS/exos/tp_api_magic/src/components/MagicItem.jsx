import {Card, CardImg, CardText, CardTitle} from "react-bootstrap";

export const MagicItem = (props) => {
    const { card } = props;
    return (
        <Card className={'m-3'} bg={'light'} style={{width: "18rem"}}>
            <CardImg variant={'top'} src={card?.imageUrl}/>
            <Card.Header>
                <CardTitle>{card.name}</CardTitle>
            </Card.Header>
            <Card.Body>
                <CardText>
                    {card.text}
                </CardText>
            </Card.Body>
        </Card>
    )
}