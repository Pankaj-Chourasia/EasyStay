import axios from "axios"

export const api = axios.create({

    baseURL : "http://localhost:9192"
})

// function add new room to the database
export async function addRoom(photo,roomType,roomPrice)
{
    const formData = new FormData()
    formdata.append("photo",photo)
    formdata.append("roomType",roomType)
    formdata.append("roomPrice",roomPrice)
    
    const response = await api.post("/rooms/add/new-room",formData)
    if(response.status === 201)
    {
        return true
    }
    else{
        return false
    }

}
/* This function gets all room types from thee database */
export async function getRoomTypes() {
	try {
		const response = await api.get("/rooms/room/types")
		return response.data
	} catch (error) {
		throw new Error("Error fetching room types")
	}
}
  