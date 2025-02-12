import SwiftUI

struct RideDetail: View {
    var ride: EclRide
    var body: some View {
        VStack {
            Text("from: \(ride.from)")
            Text("to: \(ride.to)")
            Text("time: \(ride.time)")
            Text("free seats: \(ride.seats)")
            Spacer()
        }
        .padding(.horizontal, 50)
        .padding(.top, 10)
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viwModel)
}
