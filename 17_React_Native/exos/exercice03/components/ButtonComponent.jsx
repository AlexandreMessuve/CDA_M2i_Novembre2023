import { View, Text, Pressable, StyleSheet } from 'react-native'
import React from 'react'

const ButtonComponent = (props) => {
    const handlePress = () => {
        switch (props.children) {
            case '=':
                props.calculate();
                break;
            case 'Del':
                props.delExpression();
                break;
            default:
                props.addToExpression(props.children);
                break;
        }
    }
  return (
    <Pressable style={({pressed}) => 
        [styles.buttonSize, props.styleButton, (pressed) && props.stylePressed]
    }
        onPress={handlePress}
    >
        <View>
            <Text style={props.styleText}>{props.children}</Text>
        </View>
    </Pressable>
  )
}

const styles = StyleSheet.create({
    buttonSize: {
        justifyContent: 'center',
        alignItems: 'center',
        height: 98,
        width: 98,
        marginHorizontal: 5,
        marginVertical: 5
    }
})
export default ButtonComponent