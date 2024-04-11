import { View, Text, StyleSheet, Image, Modal, Button } from 'react-native'
import React from 'react'
import UserInfo from './UserInfo';

const Exercice01 = (props) => {
    const user = {
        lastname: 'Messuve',
        firstname: 'Alex',
        phone: '06 06 06 06 06',
        address: '10 boulevard de la liberté, 59000 LILLE'
    }
    return (
        <Modal visible={props.visible}>

        
        <View style={styles.view}>
            <Text style={styles.title}>Exercice01</Text>
            <View>
                <Image style={styles.image}
                    source={
                        { uri: 'https://upload.wikimedia.org/wikipedia/commons/1/18/React_Native_Logo.png' }
                    } />
            </View>

            <View>
                <UserInfo title={'Nom :'}>{user.lastname}</UserInfo>
                <UserInfo title={'Prénom :'}>{user.firstname}</UserInfo>
                <UserInfo title={'Telephone :'}>{user.phone}</UserInfo>
                <UserInfo title={'Adresse :'}>{user.address}</UserInfo>
            </View>
            <View>
                <Button  title='Close' onPress={props.closeModal}/>
            </View>
        </View>
        </Modal>
        
    )
}

const styles = StyleSheet.create({
    title: {
        fontSize: 40,
        fontWeight: '800'
    },
    view: {
        backgroundColor: '#F5F5DC',
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    image: {
        height: 150,
        width: 150,
        borderRadius: 150,
    },
});
export default Exercice01